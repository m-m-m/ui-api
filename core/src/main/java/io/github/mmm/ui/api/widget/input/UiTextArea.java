/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiStringInput} for a multi-line text area.<br>
 * Example:
 *
 * <pre>
 * <textarea placeholder="placeholder"></textarea>
 * </pre>
 */
public interface UiTextArea extends UiStringInput, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label) and {@link #getPlaceholder() placeholder}.
   * @return the new {@link UiTextArea}.
   */
  static UiTextArea of(String name) {

    UiTextArea widget = UiWidgetFactoryNative.get().create(UiTextArea.class);
    if (name != null) {
      widget.setName(name);
      widget.setPlaceholder(name);
    }
    return widget;
  }

}
