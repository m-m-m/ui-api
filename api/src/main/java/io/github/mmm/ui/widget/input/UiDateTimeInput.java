/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiInput} for a {@link LocalDateTime}. Will allow to enter the date and time as text similar to
 * {@link UiTextInput} but also allows to open a calendar popup to pick the date. It may even support picking the time
 * from a clock popup.<br>
 * Example:
 *
 * <pre>
 * <input type="datetime-local" placeholder="placeholder">
 * </pre>
 *
 */
public interface UiDateTimeInput extends UiInput<LocalDate>, UiNativeWidget {

}
