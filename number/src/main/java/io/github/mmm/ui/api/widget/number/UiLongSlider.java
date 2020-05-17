/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiSlider} for a {@link Long} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="range">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiLongSlider extends UiSlider<Long>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiLongSlider}.
   */
  static UiLongSlider of(String name) {

    UiLongSlider widget = UiWidgetFactoryNative.get().create(UiLongSlider.class);
    widget.setName(name);
    return widget;
  }

}
