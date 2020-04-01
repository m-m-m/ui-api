/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.temporal;

import java.time.LocalDate;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.ui.widget.input.UiTextualInput;

/**
 * {@link UiTextualInput} for a {@link LocalDate}. Will allow to enter the value as text similar to {@link UiTextInput}
 * but also allows to open a calendar popup to pick the date.<br>
 * Example:
 *
 * <pre>
 * <input type="date" placeholder="placeholder">
 * </pre>
 *
 */
public interface UiDateInput extends UiTextualInput<LocalDate>, UiNativeWidget {

}
