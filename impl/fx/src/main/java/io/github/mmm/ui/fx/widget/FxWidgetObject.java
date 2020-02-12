/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiFocusGainEvent;
import io.github.mmm.ui.event.UiFocusLossEvent;
import io.github.mmm.ui.event.UiHideEvent;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.spi.widget.AbstractUiNativeWidgetWrapper;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.custom.UiCustomWidget;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * Implementation of {@link io.github.mmm.ui.widget.UiNativeWidget} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetObject<W> extends AbstractUiNativeWidgetWrapper<W> {

  /**
   * {@link PseudoClass} if JavaFx widget gets
   * {@link io.github.mmm.ui.fx.widget.input.FxInput#setValidationFailure(String) invalid}.
   */
  public static final PseudoClass CLASS_INVALID = PseudoClass.getPseudoClass("invalid");

  /**
   * {@link PseudoClass} if JavaFx widget gets {@link io.github.mmm.ui.fx.widget.input.FxInput#setReadOnly(boolean)
   * read-only}.
   */
  public static final PseudoClass CLASS_READ_ONLY = PseudoClass.getPseudoClass("read-only");

  /** @see #getWidget() */
  protected final W widget;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetObject(UiContext context, W widget) {

    super(context);
    this.widget = widget;
  }

  @Override
  public W getWidget() {

    return this.widget;
  }

  /**
   * @param uiWidget the {@link UiWidget}.
   * @return the {@link #getWidget() containing} JavaFx {@link Node}.
   */
  protected Node getTopNode(UiWidget uiWidget) {

    if (uiWidget instanceof UiCustomWidget) {
      getTopNode(((UiCustomWidget<?>) uiWidget).getDelegate());
    }
    return ((FxWidgetNode<?>) uiWidget).getTopWidget();
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

  /**
   * @param event the {@link ActionEvent}.
   */
  protected void onAction(ActionEvent event) {

    fireEvent(new UiClickEvent(this, false));
  }

  /**
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected void onFocusChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

    onFocusChanged(Boolean.TRUE.equals(newValue));
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
      validate();
    }
    fireEvent(event);
  }

  /**
   * @param <V> type of the value.
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected <V> void onValueChange(ObservableValue<? extends V> observable, V oldValue, V newValue) {

    boolean programmatic = getProgrammaticEventType() == UiValueChangeEvent.TYPE;
    if (!programmatic) {
      onValueChangedByUser();
    }
    fireEvent(new UiValueChangeEvent(this, programmatic));
  }

  /**
   * Called from {@link #onValueChange(ObservableValue, Object, Object)} if triggered by end-user.
   */
  protected void onValueChangedByUser() {

  }

  /**
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected void onClose(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

    boolean programmatic = getProgrammaticEventType() == UiHideEvent.TYPE;
    fireEvent(new UiHideEvent(this, programmatic));
  }

}