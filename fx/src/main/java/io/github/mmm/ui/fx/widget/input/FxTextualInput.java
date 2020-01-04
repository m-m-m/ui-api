/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.ui.widget.input.UiTextualInput;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link TextField}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxTextualInput<W extends TextInputControl> extends FxInput<W, String> implements UiTextualInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxTextualInput(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.nativeWidget.textProperty().addListener(this::onValueChange);
  }

  @Override
  public String getValue() {

    return this.nativeWidget.getText();
  }

  @Override
  public void setValue(String value) {

    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    this.nativeWidget.setText(value);
  }

}
