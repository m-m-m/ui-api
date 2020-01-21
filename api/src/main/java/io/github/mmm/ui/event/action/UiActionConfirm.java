/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>confirm</em>. It will acknowledge the current step or data.
 *
 * @see UiActionApprove
 * @see UiActionSubmit
 *
 * @since 1.0.0
 */
public interface UiActionConfirm extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "confirm";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
