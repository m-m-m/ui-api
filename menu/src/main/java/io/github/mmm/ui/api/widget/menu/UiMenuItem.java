/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractMenuItem} for a normal menu item that acts like a button. It can be {@link #click() clicked} and
 * invokes an {@link #addListener(io.github.mmm.ui.api.event.UiEventListener) action}.
 *
 * @since 1.0.0
 */
public interface UiMenuItem extends UiAbstractActiveMenuItem, UiNativeWidget {

  /**
   * @param text the new {@link #getText() label text} of the {@link UiMenu} to create.
   * @param listener the {@link UiEventListener} to listen for {@link UiEvent}s such as
   *        {@link io.github.mmm.ui.api.event.UiClickEvent}.
   * @return the new {@link UiMenu}.
   */
  static UiMenuItem of(String text, UiEventListener listener) {

    UiMenuItem widget = UiWidgetFactoryNative.get().create(UiMenuItem.class);
    if (text != null) {
      widget.setText(text);
    }
    if (listener != null) {
      widget.addListener(listener);
    }
    return widget;
  }
}
