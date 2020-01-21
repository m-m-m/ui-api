/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.datatype.color.Color;
import io.github.mmm.ui.widget.UiNativeWidget;

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

}
