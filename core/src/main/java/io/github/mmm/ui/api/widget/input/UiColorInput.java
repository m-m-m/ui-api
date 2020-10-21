/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.datatype.color.Color;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiInput} for a {@link Color}. Will show the color value visually and allow to enter it via a color picker
 * popup.<br>
 * Example:
 *
 * <pre>
 * <input type="color">
 * </pre>
 *
 */
public interface UiColorInput extends UiInput<Color>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiColorInput}.
   */
  static UiColorInput of(String name) {

    UiColorInput widget = UiWidgetFactoryNative.get().create(UiColorInput.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
