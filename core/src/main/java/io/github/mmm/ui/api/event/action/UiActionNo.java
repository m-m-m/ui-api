/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>no</em>. Typically used to deny a simple yes/no question popup.
 *
 * @see UiActionClose
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionNo extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "no";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
