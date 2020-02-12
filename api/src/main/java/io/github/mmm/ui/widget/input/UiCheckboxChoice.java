/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractMultiChoice} to select {@code 0-N} {@link #getOptions() options} via {@link UiCheckbox}es. You
 * should only use this input widget when you have a small number of {@link #getOptions() options} with rather short
 * text (2-5 options not longer than 10 characters each). Otherwise you should use alternatives such as
 * {@link UiMultiComboBox} for better UX. <br>
 * Example:
 *
 * <pre>
 * Features: <input
 * type="checkbox"> SSD <input
 * type="checkbox"> USB-C <input
 * type="checkbox"> DVD-Drive
 * </pre>
 *
 * <br>
 * <b>NOTICE:</b> Depending on the implementation you may receive a focus loss event immediately followed by a focus
 * gain event in case the end-user changes focus from one option to another. However, other implementations may not send
 * events in this case.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiCheckboxChoice<V> extends UiAbstractMultiChoice<V>, UiNativeWidget {

}
