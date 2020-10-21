/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;

/**
 * {@link UiNumberInput} for a {@link Long} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiLongInput extends UiNumberInput<Long>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiLongInput}.
   */
  static UiLongInput of(String name) {

    UiLongInput widget = UiWidgetFactoryNative.get().create(UiLongInput.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
