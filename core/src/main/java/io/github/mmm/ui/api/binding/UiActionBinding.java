/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding;

import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.impl.binding.UiActionBindingProvider;

/**
 * Interface to bind an {@link UiAction action} to a {@link UiAbstractButton button}.
 *
 * @since 1.0.0
 */
public interface UiActionBinding {

  /**
   * @param action the {@link UiAction} to bind.
   * @param button the {@link UiAbstractButton} to bind the action to.
   */
  void bind(UiAction action, UiAbstractButton button);

  /**
   * @return the singleton instance of this {@link UiActionBinding}.
   */
  static UiActionBinding get() {

    return UiActionBindingProvider.ACTION_BINDING;
  }
}
