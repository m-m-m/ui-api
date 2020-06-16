/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

import io.github.mmm.ui.api.event.UiEventListener;

/**
 * {@link UiEventListener} of a specific <em>action</em>. This action is invoked by a triggering widget, typically a
 * button. As the action allows to derive a {@link #getLabel() label}, a {@link #getTooltip() tooltip}, and potentially
 * an icon it can be used to create a triggering widget (typically a button) with all its aspects. Further these aspects
 * can be maintained at a single place in the code and allows a consistent user experience throughout your entire
 * application.
 *
 * @since 1.0.0
 * @see io.github.mmm.ui.api.widget.button.UiButton#of(UiAction)
 */
public abstract interface UiAction extends UiEventListener {

  /**
   * @return the ID of this action. Will be applied as {@link io.github.mmm.ui.api.widget.UiWidget#getId() widget ID}
   *         and also used to derive {@link #getLabel() label} or potentially icon automatically.
   */
  String getId();

  /**
   * @return the custom label for this action. If {@code null} the label will be derived from {@link #getId() ID}.
   */
  default String getLabel() {

    return null;
  }

  /**
   * @return the custom tooltip for this action. If {@code null} the tooltip will be derived from {@link #getId() ID}.
   */
  default String getTooltip() {

    return null;
  }

  /**
   * @return the custom {@link io.github.mmm.ui.api.widget.img.UiIcon#getIconId() icon ID} for this action. If
   *         {@code null} typically no icon is used, but it may be derived from {@link #getId() ID} via localization.
   */
  default String getIconId() {

    return null;
  }

  /**
   * @return {@code true} if the user should confirm a question popup before this action is
   *         {@link #onEvent(io.github.mmm.ui.api.event.UiEvent) invoked}.
   */
  default boolean requireConfirmation() {

    if (getConfirmationMessage() != null) {
      return true;
    }
    return false;
  }

  /**
   * @return the custom confirmation message for this action if {@link #requireConfirmation()} returns {@code true}. If
   *         {@code null} the message will be derived from {@link #getId() ID}.
   */
  default String getConfirmationMessage() {

    return null;
  }

}
