/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.temporal;

import java.time.LocalTime;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.api.widget.input.UiTextualInput;

/**
 * {@link UiInput} for a {@link LocalTime}. Will allow to enter the time as text similar to {@link UiTextInput} but more
 * structured. It may even support picking the time from a clock popup.<br>
 * Example:
 *
 * <pre>
 * <input type="time" placeholder="placeholder">
 * </pre>
 *
 */
public interface UiTimeInput extends UiTextualInput<LocalTime>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiTimeInput}.
   */
  static UiTimeInput of(UiContext context, String name) {

    UiTimeInput widget = context.create(UiTimeInput.class);
    widget.setName(name);
    return widget;
  }

}
