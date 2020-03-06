/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.button;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEventListener;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * This is the interface for an normal {@link UiAbstractButton button}. <br>
 * Here you can see an example (with {@link #setLabel(String) label} "Click me"):
 *
 * <pre>
 * <button type="button">Click me</button>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiButton extends UiAbstractButton, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param label the {@link UiButton#getLabel() label}.
   * @param listener the {@link UiEventListener}.
   * @return the new {@link UiButton}.
   * @see #of(UiContext, UiAction)
   */
  static UiButton of(UiContext context, String label, UiClickEventListener listener) {

    UiButton widget = context.create(UiButton.class);
    widget.setLabel(label);
    if (listener != null) {
      widget.addListener(listener);
    }
    return widget;
  }

  /**
   * @param context the {@link UiContext}.
   * @param action the {@link UiAction}.
   * @return the new {@link UiButton}.
   * @see UiContext#createButton(UiAction)
   */
  static UiButton of(UiContext context, UiAction action) {

    return context.createButton(action);
  }

}
