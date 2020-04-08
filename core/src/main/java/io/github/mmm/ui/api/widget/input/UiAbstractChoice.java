/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * {@link UiInput} for a choice out of a pre-define {@link List} of {@link #getOptions() options}.
 *
 * @param <O> type of the {@link #getOptions() option}.
 * @param <V> type of the {@link #getValue() value}. Should be either same as {@literal <O>} or a
 *        {@link java.util.Collection} of it.
 * @since 1.0.0
 */
public abstract interface UiAbstractChoice<O, V> extends UiInput<V> {

  /**
   * This method gets the <em>options</em> of this object. The options are the available values to choose a selection
   * from. The {@link List} shall not contain duplicate entries. It may contain the value {@code null}. In such case
   * {@link #setFormatter(Function) set a custom formatter} that provides a reasonable display value for the
   * {@code null} option.<br>
   * <b>ATTENTION:</b> Do not update the {@link List} of options from outside. See {@link #setOptions(List)} for
   * details.
   *
   * @return the {@link List} with all available options.
   */
  List<O> getOptions();

  /**
   * This method sets the {@link #getOptions() options} of this object. The options will be presented in their order
   * specified by the given {@link List}.<br>
   * <b>ATTENTION:</b> The options are updated during this method. Changing the {@link List} instance after calling this
   * method will not reflect the changes unless this method is called again.
   *
   * @param options the new {@link List} of available {@link #getOptions() options}.
   */
  void setOptions(List<O> options);

  /**
   * @param options new available {@link #getOptions() options} as array.
   * @see #setOptions(List)
   */
  @SuppressWarnings("unchecked")
  default void setOptions(O... options) {

    setOptions(Arrays.asList(options));
  }

  /**
   * @param <O> type of {@link Enum} option.
   * @param choice the {@link UiAbstractChoice}.
   * @param enumType the {@link Class} reflecting the {@link Enum} option.
   */
  static <O extends Enum<?>> void setOptionsByEnum(UiAbstractChoice<O, ?> choice, Class<O> enumType) {

    choice.setOptions(enumType.getEnumConstants());
  }

  /**
   * @return the formatter to {@link Function#apply(Object) format} an {@link #getOptions() option} to {@link String} in
   *         order to display it in the UI. By default it will simply use
   *         {@link io.github.mmm.ui.spi.ToStringFormatter}. Use {@link #setFormatter(Function)} to change default.
   */
  Function<O, String> getFormatter();

  /**
   *
   * @param formatter the new value of {@link #getFormatter()}.
   */
  void setFormatter(Function<O, String> formatter);
}
