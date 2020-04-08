/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractSingleChoice} for a <em>combo-box</em> that allows the end-user to expand a drop-down menu and
 * select the {@link #getValue() value} from a given list of {@link #getOptions() options}. However, the combo-box is
 * also and editable text input field that allows the user to enter the value manually including auto-completion from
 * the given {@link #getOptions() options} what is a valuable feature for accessibility and power-usage.<br>
 * (Simplified) example (press arrow down in the text field):
 *
 * <pre>
 * Fruits: <input
 * type="text" list="fruits" placeholder="Enter a fruit">
 * <datalist id="fruits">
 *   <option value="Apple"></option>
 *   <option value="Orange"></option>
 *   <option value="Peach"></option>
 * </datalist>
 * </pre>
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiComboBox<V> extends UiAbstractSingleChoice<V>, UiTextualInput<V>, UiNativeWidget {

}
