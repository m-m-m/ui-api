/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>cancel</em>. It will typically abort something and is used to close a popup without further
 * changes.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionDiscard extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Discard";

  @Override
  default String getId() {

    return ACTION_ID;
  }

  @Override
  default boolean requireConfirmation() {

    return true;
  }
}
