/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.value.UiAbstractCheckbox;

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
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiCheckbox}.
   */
  static UiCheckbox of(UiContext context, String name) {

    UiCheckbox widget = context.create(UiCheckbox.class);
    widget.setName(name);
    return widget;
  }

}
