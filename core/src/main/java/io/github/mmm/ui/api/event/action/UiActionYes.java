/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>yes</em>. Typically used to confirm a simple yes/no question popup.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionYes extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Yes";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
