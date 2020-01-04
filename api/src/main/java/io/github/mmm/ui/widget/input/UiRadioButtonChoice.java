/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractSingleChoice} to select a value from a group of {@link UiRadioButton}s. You should only use this
 * input widget when you have a small number of {@link #getOptions() options} with rather short text (2-5 options not
 * longer than 10 characters).<br>
 * Example:
 *
 * <pre>
 * Matrimony: <input
 * type="radio" name="status"> single</input> <input
 * type="radio" name="status"> married</input> <input
 * type="radio" name="status"> divorced</input>
 * </pre>
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiRadioButtonChoice<V> extends UiAbstractSingleChoice<V>, UiNativeWidget {

}
