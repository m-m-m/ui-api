/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import java.time.LocalTime;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiInput} for a {@link LocalTime}. Will allow to enter the time as text similar to {@link UiTextInput} but more
 * structured. It may even support picking the time from a clock popup.<br>
 * Example:
 *
 * <pre>
 * <input type="range">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiIntegerSlider extends UiSlider<Integer>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiIntegerSlider}.
   */
  static UiIntegerSlider of(UiContext context, String name) {

    UiIntegerSlider widget = context.create(UiIntegerSlider.class);
    widget.setName(name);
    return widget;
  }

}
