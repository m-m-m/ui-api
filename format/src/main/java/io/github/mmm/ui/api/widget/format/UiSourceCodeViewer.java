/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.format;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.value.UiValuedWidget;

/**
 * {@link UiValuedWidget} that displays its {@link #getValue() value} as source-code (with line-numbers and syntax
 * highlighting).
 *
 * @since 1.0.0
 */
public interface UiSourceCodeViewer extends UiValuedWidget<String>, UiRegularWidget, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param code the {@link #getValue() value} (source-code to display).
   * @return the new {@link UiSourceCodeViewer}.
   */
  static UiSourceCodeViewer of(UiContext context, String code) {

    UiSourceCodeViewer widget = context.create(UiSourceCodeViewer.class);
    widget.setValue(code);
    return widget;
  }

}
