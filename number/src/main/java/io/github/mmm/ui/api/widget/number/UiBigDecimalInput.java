/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import java.math.BigDecimal;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiNumberInput} for a {@link BigDecimal} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiBigDecimalInput extends UiNumberInput<BigDecimal>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiBigDecimalInput}.
   */
  static UiBigDecimalInput of(String name) {

    UiBigDecimalInput widget = UiWidgetFactoryNative.get().create(UiBigDecimalInput.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

}
