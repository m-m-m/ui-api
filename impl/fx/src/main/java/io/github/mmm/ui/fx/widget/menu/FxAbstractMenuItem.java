/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.fx.widget.FxWidgetStyleable;
import io.github.mmm.ui.widget.menu.UiAbstractActiveMenuItem;
import io.github.mmm.ui.widget.menu.UiMenuItemSeparator;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiAbstractActiveMenuItem} using JavaFx {@link MenuItem}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuItem<W extends MenuItem> extends FxWidgetStyleable<W>
    implements UiAbstractActiveMenuItem {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractMenuItem(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    if (!(this instanceof UiMenuItemSeparator)) {
      this.widget.setOnAction(this::onAction);
    }
  }

  @Override
  public void setId(String id) {

    this.widget.setId(id);
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
  public void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
  }

  @Override
  public void setVisibleNative(boolean visible) {

    this.widget.setVisible(visible);
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
    this.widget.setOnAction(null);
  }

}
