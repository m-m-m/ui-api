/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiVisibleFlags;
import io.github.mmm.ui.fx.widget.FxAtomicWidget;
import io.github.mmm.ui.fx.widget.composite.FxComposite;
import io.github.mmm.ui.fx.widget.composite.FxTab;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.panel.UiTabPanel;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Implementation of {@link UiTabPanel} using JavaFx {@link TabPane}.
 *
 * @since 1.0.0
 */
public class FxTabPanel extends FxComposite<TabPane, UiTab> implements UiTabPanel, FxAtomicWidget<TabPane> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxTabPanel(UiContext context) {

    super(context, new TabPane());
  }

  private Tab getTab(UiTab child) {

    return ((FxTab) child).getWidget();
  }

  @Override
  public void addChild(UiTab child, int index) {

    FxTab fxTab = (FxTab) child;
    this.widget.getTabs().add(fxTab.getWidget());
    this.children.add(index, child);
    setParent(child, this);
  }

  @Override
  public boolean removeChild(UiTab child) {

    boolean removed = this.children.remove(child);
    if (removed) {
      this.widget.getTabs().remove(getTab(child));
    }
    return removed;
  }

  @Override
  public UiTab removeChild(int index) {

    this.widget.getTabs().remove(index);
    return this.children.remove(index);
  }

  @Override
  public UiTab getActiveChild() {

    Tab tab = this.widget.getSelectionModel().getSelectedItem();
    if (tab == null) {
      return null;
    }
    return FxTab.get(tab);
  }

  @Override
  public int getActiveChildIndex() {

    Tab tab = this.widget.getSelectionModel().getSelectedItem();
    if (tab == null) {
      return -1;
    }
    FxTab fxTab = FxTab.get(tab);
    return this.children.indexOf(fxTab);
  }

  @Override
  public boolean setActiveChild(UiTab child) {

    this.widget.getSelectionModel().select(getTab(child));
    return true;
  }

  /**
   * @param fxTab the {@link FxTab} to change visibility.
   * @param visible - {@code true} to show, {@code false} to hide.
   */
  public void setTabVisible(FxTab fxTab, boolean visible) {

    ObservableList<Tab> tabs = this.widget.getTabs();
    if (visible) {
      int index = 0;
      for (UiTab uiTab : this.children) {
        if (uiTab == fxTab) {
          tabs.add(index, fxTab.getWidget());
          return;
        } else {
          if (uiTab.isVisible(UiVisibleFlags.ANY)) {
            index++;
          }
        }
      }
    } else {
      tabs.remove(fxTab.getWidget());
    }
  }

}
