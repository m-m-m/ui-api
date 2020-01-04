/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

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
   * from. The {@link List} shall not contain duplicate entries. It may contain the value <code>null</code>.
   *
   * @return the {@link List} with all available options.
   */
  List<O> getOptions();

  /**
   * This method sets the {@link #getOptions() options} of this object. The options will be presented in their order
   * specified by the given {@link List}.
   *
   * @param options is the new {@link List} of available {@link #getOptions() options}.
   */
  void setOptions(List<O> options);

  /**
   * @return the formatter to {@link Function#apply(Object) format} an {@link #getOptions() option} to {@link String} in
   *         order to display it in the UI. By default it will simply use {@link Object#toString()}. Use
   *         {@link #setFormatter(Function)} to change default.
   */
  Function<O, String> getFormatter();

  /**
   *
   * @param formatter the new value of {@link #getFormatter()}.
   */
  void setFormatter(Function<O, String> formatter);
}
