/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>approve</em>. It will typically confirm that a proposed change should finally be completed.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionApprove extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "approve";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
