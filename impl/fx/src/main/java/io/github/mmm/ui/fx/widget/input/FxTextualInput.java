/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextualInput;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

/**
 * Implementation of {@link UiTextualInput} using JavaFx {@link TextField}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxTextualInput<W extends TextInputControl, V> extends FxInput<W, V> implements UiTextualInput<V> {

  private String autocomplete;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public FxTextualInput(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    this.widget.setEditable(readOnly);
  }

  @Override
  public String getPlaceholder() {

    return this.widget.getPromptText();
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.widget.setPromptText(placeholder);
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    // Not supported by JavaFx
    this.autocomplete = autocomplete;
  }

}
