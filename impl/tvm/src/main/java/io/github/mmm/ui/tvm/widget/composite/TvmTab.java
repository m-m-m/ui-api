/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.composite;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.panel.TvmTabPanel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiComposite;
import io.github.mmm.ui.widget.composite.UiTab;

/**
 * Implementation of {@link UiTab} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmTab extends TvmComposite<HTMLButtonElement, UiRegularWidget> implements UiTab {

  private final HTMLElement labelWidget;

  private final HTMLElement sectionWidget;

  private final HTMLElement errorWidget;

  private String label;

  private UiRegularWidget child;

  private boolean closable;

  private boolean selected;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmTab(UiContext context) {

    super(context, newButton());
    this.widget.setAttribute(ATR_ROLE, "tab");
    HTMLDocument document = Window.current().getDocument();
    this.errorWidget = newIcon(CLASS_ERROR);
    this.errorWidget.setHidden(true);
    this.widget.appendChild(this.errorWidget);
    this.labelWidget = newLabel();
    this.widget.appendChild(this.labelWidget);
    this.label = "";
    this.closable = false;
    this.sectionWidget = document.createElement("section");
    setSelected(false);
    this.widget.addEventListener(EVENT_TYPE_CLICK, this::onClick);
  }

  private TvmTabPanel getTabPanel() {

    UiComposite<?> parent = getParent();
    if (parent instanceof TvmTabPanel) {
      return (TvmTabPanel) parent;
    }
    return null;
  }

  @Override
  protected void onClick(Event event) {

    super.onClick(event);
    TvmTabPanel tabPanel = getTabPanel();
    if (tabPanel != null) {
      tabPanel.setActiveChild(this);
    }
  }

  /**
   * @return the widget with the {@link #getChild() content} of this tab.
   */
  public HTMLElement getSectionWidget() {

    return this.sectionWidget;
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (child == this.child) {
      return;
    }
    if (this.child != null) {
      setParent(this.child, null);
    }
    this.child = child;
    this.sectionWidget.clear();
    this.sectionWidget.appendChild(getTopNode(child));
    setParent(child, this);
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
  }

  @Override
  public boolean isClosable() {

    return this.closable;
  }

  @Override
  public void setClosable(boolean closable) {

    if (closable == this.closable) {
      return;
    }
    this.widget.setAttribute("closable", Boolean.toString(closable));
    this.closable = closable;
  }

  @Override
  public char getAccessKey() {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public String getLabel() {

    return this.label;
  }

  @Override
  public void setLabel(String label) {

    if (label == null) {
      label = "";
    }
    this.label = label;
    setTextContent(this.labelWidget, label);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    super.setVisibleNative(visible);
    if (!visible) {
      this.sectionWidget.setAttribute(ATR_ARIA_HIDDEN, "true");
      if (this.selected) {
        TvmTabPanel tabPanel = getTabPanel();
        if (tabPanel != null) {
          int activeChildIndex = tabPanel.getActiveChildIndex();
          if (activeChildIndex == 0) {
            tabPanel.selectNextTab();
          } else {
            tabPanel.selectPreviousTab();
          }
        }
      }
    }
  }

  /**
   * @param selected {@code true} to set this tab selected, {@code false} for deselected.
   */
  public void setSelected(boolean selected) {

    setSelected(selected, selected);
  }

  /**
   * @param selected {@code true} to set this tab selected, {@code false} for deselected.
   * @param focus {@code true} to focus this tab, {@code false} otherwise.
   */
  public void setSelected(boolean selected, boolean focus) {

    this.widget.setAttribute(ATR_TABINDEX, selected ? "0" : "-1");
    this.widget.setAttribute(ATR_ARIA_SELECTED, Boolean.toString(selected));
    this.sectionWidget.setAttribute(ATR_ARIA_HIDDEN, Boolean.toString(!selected));
    this.selected = selected;
    if (focus) {
      this.widget.focus();
    }
  }

  @Override
  protected void doSetValidationFailure(String error) {

    super.doSetValidationFailure(error);
    this.errorWidget.setHidden(error == null);
    this.errorWidget.setTitle(error);
    if (error == null) {
      this.sectionWidget.setClassName("");
    } else {
      this.sectionWidget.setClassName(STYLE_INVALID);
    }
  }

}
