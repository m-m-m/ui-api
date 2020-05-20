/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiAction} for <em>reset</em>. It will typically discard the current changes and revert the data.
 *
 * @since 1.0.0
 * @see UiWidget#reset()
 */
@FunctionalInterface
public interface UiActionReset extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Reset";

  @Override
  default String getId() {

    return ACTION_ID;
  }

  @Override
  default boolean requireConfirmation() {

    return true;
  }

  /**
   * @param widget the {@link UiWidget} to {@link UiWidget#reset() reset}.
   * @return the new {@link UiActionReset} to {@link UiWidget#reset() reset} the given {@link UiWidget}.
   */
  static UiActionReset of(UiWidget widget) {

    return e -> widget.reset();
  }

}
