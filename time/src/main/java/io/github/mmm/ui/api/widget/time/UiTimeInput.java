/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.time;

import java.time.LocalTime;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
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
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiTimeInput}.
   */
  static UiTimeInput of(String name) {

    UiTimeInput widget = UiWidgetFactoryNative.get().create(UiTimeInput.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
