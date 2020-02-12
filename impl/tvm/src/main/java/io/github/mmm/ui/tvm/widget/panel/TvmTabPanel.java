/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.KeyboardEvent;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiEnabledFlags;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.tvm.widget.composite.TvmTab;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.panel.UiTabPanel;

/**
 * Implementation of {@link UiTabPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmTabPanel extends TvmDynamicComposite<HTMLElement, UiTab> implements UiTabPanel {

  private final HTMLElement topWidget;

  private int selectedTabIndex;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmTabPanel(UiContext context) {

    super(context, Window.current().getDocument().createElement("ui-tabs"));
    this.topWidget = Window.current().getDocument().createElement("ui-tabpanel");
    this.topWidget.appendChild(this.widget);
    this.selectedTabIndex = -1;
    this.widget.addEventListener("keydown", this::onKeyDown);
  }

  private void onKeyDown(Event e) {

    KeyboardEvent keyEvent = e.cast();
    switch (keyEvent.getKeyCode()) {
      case 37: // arrow left
      case 38: // arrow up
        int previous = this.selectedTabIndex - 1;
        if (previous < 0) {
          previous = this.children.size() - 1;
        }
        setActiveChildIndex(previous);
        break;
      case 39: // arrow right
      case 40: // arrow down
        int next = this.selectedTabIndex + 1;
        if (next >= this.children.size()) {
          next = 0;
        }
        setActiveChildIndex(next);
        break;
    }
  }

  @Override
  public HTMLElement getTopWidget() {

    return this.topWidget;
  }

  @Override
  public void addChild(UiTab child, int index) {

    super.addChild(child, index);
    TvmTab tab = (TvmTab) child;
    this.topWidget.appendChild(tab.getSectionWidget());
  }

  @Override
  public boolean removeChild(UiTab child) {

    boolean removed = super.removeChild(child);
    if (removed) {
      TvmTab tab = (TvmTab) child;
      this.topWidget.appendChild(tab.getSectionWidget());
    }
    return removed;
  }

  @Override
  public UiTab removeChild(int index) {

    UiTab child = super.removeChild(index);
    if (child != null) {
      TvmTab tab = (TvmTab) child;
      this.topWidget.appendChild(tab.getSectionWidget());
    }
    return child;
  }

  @Override
  public int getActiveChildIndex() {

    return this.selectedTabIndex;
  }

  @Override
  public void setActiveChildIndex(int index) {

    UiTab tab = getChild(index);
    if (tab == null) {
      return;
    }
    setActiveChild(tab, index);
  }

  @Override
  public boolean setActiveChild(UiTab child) {

    int index = this.children.indexOf(child);
    if (index < 0) {
      return false;
    }
    setActiveChild(child, index);
    return true;
  }

  private void setActiveChild(UiTab tab, int index) {

    UiTab previousTab = getChild(this.selectedTabIndex);
    if (previousTab != null) {
      ((TvmTab) tab).setSelected(false);
    }
    this.selectedTabIndex = index;
    ((TvmTab) tab).setSelected(true);
    UiTabPanel.super.setActiveChildIndex(index);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    int size = this.children.size();
    for (int i = 0; i < size; i++) {
      TvmTab tab = (TvmTab) this.children.get(i);
      tab.setEnabled(enabled, UiEnabledFlags.PARENT);
    }
  }

}
