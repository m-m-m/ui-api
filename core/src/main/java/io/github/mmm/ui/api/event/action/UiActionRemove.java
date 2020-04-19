/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>edit</em>. It will remove the current selection. Unlike {@link UiActionDelete} the removal
 * will not be persistent immediately so the user still has the option to {@link UiActionSave save} or
 * {@link UiActionReset reset} this change.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionRemove extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Remove";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
