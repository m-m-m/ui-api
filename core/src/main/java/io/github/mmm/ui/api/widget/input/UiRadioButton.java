/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.value.UiAbstractRadioButton;

/**
 * A regular {@link UiAbstractRadioButton radio-button widget}.<br>
 * Example:
 *
 * <pre>
 * <input type="radio" title="tooltip">Label</input>
 * </pre>
 *
 * In most cases you should use {@link UiRadioChoice} instead.
 *
 * @since 1.0.0
 */
public interface UiRadioButton extends UiAbstractRadioButton, UiInput<Boolean>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiRadioButton}.
   */
  static UiRadioButton of(String name) {

    UiRadioButton widget = UiWidgetFactoryNative.get().create(UiRadioButton.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

}
