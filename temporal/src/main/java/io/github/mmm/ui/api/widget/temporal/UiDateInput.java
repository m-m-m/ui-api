/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.temporal;

import java.time.LocalDate;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.input.UiTextualInput;

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

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label) and {@link #getPlaceholder() placeholder}.
   * @return the new {@link UiDateInput}.
   */
  static UiDateInput of(UiContext context, String name) {

    UiDateInput widget = context.create(UiDateInput.class);
    widget.setName(name);
    widget.setPlaceholder(name);
    return widget;
  }

}
