/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiNativeWidget} implementations that wrap widgets from an existing UI toolkit should implement this interface.
 *
 * @param <W> type of {@link #getWidget() native widget}.
 * @since 1.0.0
 */
public interface UiNativeWidgetWrapper<W> extends UiNativeWidget {

  /**
   * @return the top-level native widget of this wrapper. In many cases this is the same as {@link #getWidget()} but in
   *         some cases this may be some kind of internal composite containing the {@link #getWidget() main widget}.
   */
  default Object getTopWidget() {

    return getWidget();
  }

  /**
   * @return the underlying native widget wrapped by this {@link UiNativeWidget}.
   */
  W getWidget();

}
