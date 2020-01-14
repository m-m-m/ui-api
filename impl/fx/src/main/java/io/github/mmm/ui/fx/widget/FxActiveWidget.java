/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiFocusGainEvent;
import io.github.mmm.ui.event.UiFocusLossEvent;
import io.github.mmm.ui.widget.UiActiveWidget;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Control;

/**
 * Implementation of {@link UiActiveWidget} based on JavaFx {@link Control}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxActiveWidget<W extends Control> extends FxWidgetControl<W> implements UiActiveWidget {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxActiveWidget(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.focusedProperty().addListener(this::onFocusChange);
  }

  private void onFocusChange(ObservableValue<? extends Boolean> property, Boolean oldValue, Boolean newValue) {

    onFocusChanged(Boolean.TRUE.equals(newValue));
  }

  /**
   * @param event the {@link ActionEvent}.
   */
  protected void onAction(ActionEvent event) {

    fireEvent(new UiClickEvent(this, false));
  }

  /**
   * @param focusGain {@code true} if the focus was gained, {@code false} otherwise (focus has been lost).
   */
  protected void onFocusChanged(boolean focusGain) {

    UiEvent event;
    if (focusGain) {
      event = UiFocusGainEvent.of(this, getProgrammaticEventType());
    } else {
      event = UiFocusLossEvent.of(this, getProgrammaticEventType());
    }
    fireEvent(event);
  }

  @Override
  public char getAccessKey() {

    // TODO
    return ACCESS_KEY_NONE;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isFocused() {

    return this.widget.isFocused();
  }

  @Override
  public boolean setFocused() {

    setProgrammaticEventType(UiFocusGainEvent.TYPE);
    this.widget.requestFocus();
    return true;
  }

}
