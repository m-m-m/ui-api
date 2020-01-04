/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.spi.widget.UiNativeWidgetWrapper;
import javafx.css.Styleable;

/**
 * {@link UiNativeWidgetWrapper} for JavaFx {@link Styleable}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public interface FxStyleableWidget<W extends Styleable> extends UiNativeWidgetWrapper<W> {

  @Override
  default String getId() {

    return getNativeWidget().getId();
  }

}
