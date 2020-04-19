/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>edit</em>. It will allow the user to go back to the previous item or step.
 *
 * @see UiActionNext
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionPrevious extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Previous";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
