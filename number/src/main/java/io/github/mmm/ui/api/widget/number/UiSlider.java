/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

/**
 * {@link UiNumericInput} for a {@link Number} {@link #getValue() value} via a slider. A slider is like a kind of button
 * that can be slided along a horizontal scale.<br>
 * Example:
 *
 * <pre>
 * <input type="range">
 * </pre>
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiSlider<V extends Number> extends UiNumericInput<V> {

  /**
   * @return {@code true} if the output ({@link #getValue() value} as text beside the slider) is visible, {@code false}
   *         otherwise. By default output should be visible.
   */
  boolean isTextVisible();

  /**
   * @param textVisible the new value of {@link #isTextVisible()}.
   */
  void setTextVisible(boolean textVisible);

  /**
   * @return {@code true} if the output ({@link #getValue() value} as text beside the slider) is editable, {@code false}
   *         otherwise. By default output is not editable. This can be {@link #setTextEditable(boolean) changed} to
   *         allow power-users to edit the value by typing what is usually faster than moving the slider. However, if
   *         efficient typing of the value by power-users is an issue, you should consider using {@link UiNumberInput}
   *         instead.
   */
  boolean isTextEditable();

  /**
   * @param textEditable the new value of {@link #isTextEditable()}.
   */
  void setTextEditable(boolean textEditable);

}
