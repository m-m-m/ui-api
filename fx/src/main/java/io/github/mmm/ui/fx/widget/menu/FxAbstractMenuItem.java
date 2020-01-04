/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.fx.widget.FxWidgetStyleable;
import io.github.mmm.ui.widget.menu.UiAbstractActiveMenuItem;
import io.github.mmm.ui.widget.menu.UiMenuItem;
import io.github.mmm.ui.widget.menu.UiMenuItemSeparator;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiMenuItem} using JavaFx {@link MenuItem}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuItem<W extends MenuItem> extends FxWidgetStyleable<W>
    implements UiAbstractActiveMenuItem {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxAbstractMenuItem(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    if (!(this instanceof UiMenuItemSeparator)) {
      this.nativeWidget.setOnAction(this::onAction);
    }
  }

  private void onAction(ActionEvent event) {

    fireEvent(new UiClickEvent(this, false));
  }

  @Override
  public void setId(String id) {

    this.nativeWidget.setId(id);
  }

  @Override
  public String getLabel() {

    return this.nativeWidget.getText();
  }

  @Override
  public void setLabel(String label) {

    this.nativeWidget.setText(label);
  }

  @Override
  public void setEnabledNative(boolean enabled) {

    this.nativeWidget.setDisable(!enabled);
  }

  @Override
  public void setVisibleNative(boolean visible) {

    this.nativeWidget.setVisible(visible);
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
  public char getAccessKey() {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

  @Override
  protected void doDispose() {

    super.doDispose();
    this.nativeWidget.setOnAction(null);
  }

}
