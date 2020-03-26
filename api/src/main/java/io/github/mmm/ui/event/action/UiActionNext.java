/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>edit</em>. It will allow the user to proceed to the next item or step.
 *
 * @see UiActionPrevious
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionNext extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "next";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
