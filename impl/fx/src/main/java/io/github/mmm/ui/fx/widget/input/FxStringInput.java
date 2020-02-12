/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.widget.input.UiStringInput;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

/**
 * Implementation of {@link FxTextualInput} with {@link String} {@link #getValue() value} using JavaFx
 * {@link TextField}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxStringInput<W extends TextInputControl> extends FxTextualInput<W, String>
    implements UiStringInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public FxStringInput(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.textProperty().addListener(this::onValueChange);
  }

  @Override
  public String getValue() {

    return this.widget.getText();
  }

  @Override
  public void setValueNative(String value) {

    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    this.widget.setText(value);
  }

}
