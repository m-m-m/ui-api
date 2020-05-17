/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.number;

import java.math.BigInteger;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiNumberInput} for a {@link BigInteger} {@link #getValue() value}.<br>
 * Example:
 *
 * <pre>
 * <input type="number" placeholder="placeholder">
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiBigIntegerInput extends UiNumberInput<BigInteger>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiBigIntegerInput}.
   */
  static UiBigIntegerInput of(String name) {

    UiBigIntegerInput widget = UiWidgetFactoryNative.get().create(UiBigIntegerInput.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

}
