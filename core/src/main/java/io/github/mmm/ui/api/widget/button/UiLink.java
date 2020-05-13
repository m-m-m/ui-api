/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.button;

import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiRegularWidget} that represents a hyperlink (link). A link is some text that is highlighted and can be
 * clicked in order to navigate somewhere.<br>
 * <b>ATTENTION:</b> For usability a {@link UiLink} shall invoke an action that navigates somewhere. For actions that
 * change some state, load additional data, or do something that does not switch the current dialog use other widgets,
 * typically {@link UiButton} instead.<br>
 * Here you can see an example (with {@link #setText(String) label} "Click me"):
 *
 * <pre>
 * <a href="https://en.wikipedia.org/wiki/Hyperlink">Click me</a>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiLink extends UiAbstractButton, UiNativeWidget {

  /**
   * @return the hyperlink reference. Typically an URL to open when the link is clicked.
   */
  String getHref();

  /**
   * @param href the new value of {@link #getHref()}.
   */
  void setHref(String href);

  /**
   * @param label the {@link UiButton#getText() label}.
   * @param listener the {@link UiEventListener}.
   * @return the new {@link UiButton}.
   * @see #of(UiAction)
   */
  static UiLink of(String label, UiClickEventListener listener) {

    UiLink widget = UiWidgetFactoryNative.get().create(UiLink.class);
    widget.setText(label);
    if (listener != null) {
      widget.addListener(listener);
    }
    return widget;
  }

  /**
   * @param action the {@link UiAction}.
   * @return the new {@link UiButton}.
   */
  static UiLink of(UiAction action) {

    UiLink button = UiWidgetFactoryNative.get().create(UiLink.class);
    UiActionBinding.get().bind(action, button);
    return button;
  }
}
