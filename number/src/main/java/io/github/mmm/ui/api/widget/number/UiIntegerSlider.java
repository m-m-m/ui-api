/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;

/**
 * {@link UiSlider} for an {@link Integer} {@link #getValue() value}.<br>
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
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiIntegerSlider}.
   */
  static UiIntegerSlider of(String name) {

    UiIntegerSlider widget = UiWidgetFactoryNative.get().create(UiIntegerSlider.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
