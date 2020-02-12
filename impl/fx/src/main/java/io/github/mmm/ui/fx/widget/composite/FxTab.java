/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.FxWidgetStyleable;
import io.github.mmm.ui.fx.widget.panel.FxTabPanel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiComposite;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.panel.UiTabPanel;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;

/**
 * Implementation of {@link UiTab} using JavaFx {@link Tab}.
 *
 * @since 1.0.0
 */
public class FxTab extends FxWidgetStyleable<Tab> implements UiTab {

  private UiRegularWidget child;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxTab(UiContext context) {

    super(context, new Tab());
    this.widget.setUserData(this);
    this.widget.setClosable(false);
  }

  private FxTabPanel getTabPanel() {

    return (FxTabPanel) getParent();
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.closableProperty().addListener(this::onClose);
  }

  @Override
  protected void onClose(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

    super.onClose(observable, oldValue, newValue);
    UiComposite<?> parent = getParent();
    if (parent != null) {
      ((UiTabPanel) parent).removeChild(this);
    }
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (child == this.child) {
      return;
    }
    if (this.child != null) {
      setParent(this.child, null);
    }
    this.widget.setContent(getTopNode(child));
    this.child = child;
    setParent(child, this);
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
  }

  @Override
  public String getLabel() {

    return this.widget.getText();
  }

  @Override
  public void setLabel(String label) {

    this.widget.setText(label);
  }

  @Override
  public void setId(String id) {

    this.widget.setId(id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    FxTabPanel tabPanel = getTabPanel();
    if (tabPanel != null) {
      tabPanel.setTabVisible(this, visible);
    }
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
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
  public boolean isFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isClosable() {

    return this.widget.isClosable();
  }

  @Override
  public void setClosable(boolean closable) {

    this.widget.setClosable(closable);
    if (closable) {
      ensureHandlers();
    }
  }

  /**
   * @param tab the JavaFx {@link Tab}.
   * @return the owning {@link FxTab}.
   */
  public static FxTab get(Tab tab) {

    return (FxTab) tab.getUserData();
  }

}
