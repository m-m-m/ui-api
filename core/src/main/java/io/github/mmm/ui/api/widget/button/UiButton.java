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
import io.github.mmm.ui.api.widget.link.UiAbstractLink;

/**
 * This is the interface for an normal {@link UiAbstractButton button}. Unlike a {@link UiAbstractLink} it typically
 * changes some state. Only use a {@link UiButton} for navigation in case the navigation target depends on some other
 * widget or selection. E.g. in a master/detail panel you may select an element from a list and have buttons to delete
 * or edit the selected element. While the "edit" button will only navigate to another dialog the result depends on the
 * selected element. If the navigation target will be independent from external state always prefer a
 * {@link UiAbstractLink} instead.<br>
 * Here you can see an example (with {@link #setText(String) setText("Click me")}):
 *
 * <pre>
 * <button type="button">Click me</button>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiButton extends UiAbstractButton, UiRegularWidget, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name for a button. */
  String STYLE = "ui-button";

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
