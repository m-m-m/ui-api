/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.button;

import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * This is the interface for an normal {@link UiAbstractButton button}. <br>
 * Here you can see an example (with {@link #setText(String) label} "Click me"):
 *
 * <pre>
 * <button type="button">Click me</button>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiButton extends UiAbstractButton, UiNativeWidget {

  /**
   * @param label the {@link UiButton#getText() label}.
   * @param listener the {@link UiEventListener}.
   * @return the new {@link UiButton}.
   * @see #of(UiAction)
   */
  static UiButton of(String label, UiClickEventListener listener) {

    UiButton widget = UiWidgetFactoryNative.get().create(UiButton.class);
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
  static UiButton of(UiAction action) {

    UiButton button = UiWidgetFactoryNative.get().create(UiButton.class);
    UiActionBinding.get().bind(action, button);
    return button;
  }
}
