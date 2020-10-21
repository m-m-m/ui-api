/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.value.UiAbstractCheckbox;

/**
 * A regular {@link UiAbstractCheckbox checkbox widget}.<br>
 * Example:
 *
 * <pre>
 * <input type="checkbox" title="tooltip">Label</input>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiCheckbox extends UiAbstractCheckbox, UiInput<Boolean>, UiNativeWidget {

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiCheckbox}.
   */
  static UiCheckbox of(String name) {

    UiCheckbox widget = UiWidgetFactoryNative.get().create(UiCheckbox.class);
    UiAbstractInput.initName(widget, name);
    return widget;
  }

}
