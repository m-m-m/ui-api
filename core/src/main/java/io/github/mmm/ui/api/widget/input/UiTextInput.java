/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiStringInput} for a single-line text input. <br>
 * Example:
 *
 * <pre>
 * <input type="text" placeholder="placeholder" title="tooltip"/>
 * </pre>
 */
public interface UiTextInput extends UiStringInput, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label) and {@link #getPlaceholder() placeholder}.
   * @return the new {@link UiTextInput}.
   */
  static UiTextInput of(String name) {

    UiTextInput widget = UiWidgetFactoryNative.get().create(UiTextInput.class);
    if (name != null) {
      widget.setName(name);
      widget.setPlaceholder(name);
    }
    return widget;
  }

}
