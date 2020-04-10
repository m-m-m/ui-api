/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiNumberInput} for an {@link Integer} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiIntegerInput extends UiNumberInput<Integer>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiIntegerInput}.
   */
  static UiIntegerInput of(String name) {

    UiIntegerInput widget = UiWidgetFactoryNative.get().create(UiIntegerInput.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

}
