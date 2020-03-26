/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>edit</em>. It will delete the current selection and make the change persistent immediately
 * (unlike {@link UiActionRemove}).
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionDelete extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "delete";

  @Override
  default String getId() {

    return ACTION_ID;
  }

  @Override
  default boolean requireConfirmation() {

    return true;
  }
}
