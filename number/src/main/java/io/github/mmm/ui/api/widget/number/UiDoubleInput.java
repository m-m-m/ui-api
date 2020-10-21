/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;

/**
 * {@link UiNumberInput} for a {@link Double} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiDoubleInput extends UiNumberInput<Double>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiDoubleInput}.
   */
  static UiDoubleInput of(String name) {

    UiDoubleInput widget = UiWidgetFactoryNative.get().create(UiDoubleInput.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
