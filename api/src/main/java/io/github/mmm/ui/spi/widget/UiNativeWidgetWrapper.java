/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiNativeWidget} implementations that wrap widgets from an existing UI toolkit should implement this interface.
 *
 * @param <W> type of {@link #getNativeWidget() native widget}.
 * @since 1.0.0
 */
public interface UiNativeWidgetWrapper<W> extends UiNativeWidget {

  /**
   * @return the underlying native widget wrapped by this {@link UiNativeWidget}.
   */
  W getNativeWidget();

}
