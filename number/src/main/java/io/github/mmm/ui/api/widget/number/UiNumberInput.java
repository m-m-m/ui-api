/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.input.UiTextualInput;

/**
 * {@link UiInput} for a {@link Number} {@link #getValue() value}. Will allow to enter the time as text similar to
 * {@link UiTextInput} but more structured. It may support buttons to increment and decrement the value.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder" step="0.5">
 * </pre>
 *
 * @param <V> type of the {@link #getValue() value}. Typically {@link String}.
 * @since 1.0.0
 */
public abstract interface UiNumberInput<V extends Number> extends UiTextualInput<V>, UiNumericInput<V> {

  /**
   * @return the step value to increment or decrement the current value via icon buttons.
   */
  V getStep();

  /**
   * @param step the new value of {@link #getStep()}.
   */
  void setStep(V step);

}
