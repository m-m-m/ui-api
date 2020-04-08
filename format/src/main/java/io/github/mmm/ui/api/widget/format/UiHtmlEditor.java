/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.format;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiInput} for a rich text editor using HTML as its {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public interface UiHtmlEditor extends UiInput<String>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiHtmlEditor}.
   */
  static UiHtmlEditor of(UiContext context, String name) {

    UiHtmlEditor widget = context.create(UiHtmlEditor.class);
    widget.setName(name);
    return widget;
  }

}
