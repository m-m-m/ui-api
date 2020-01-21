/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>yes</em>. Typically used to confirm a
 * {@link io.github.mmm.ui.UiContext#showPopupYesNo(String, String, java.util.function.Consumer) simple question popup}.
 *
 * @since 1.0.0
 */
public interface UiActionYes extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "yes";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
