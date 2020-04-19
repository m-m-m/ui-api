/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>ok</em>. Typically used to close a confirmation popup.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionOk extends UiAction {

  /** A {@link UiActionOk} that does nothing {@link #onEvent(io.github.mmm.ui.api.event.UiEvent) on event}. */
  UiActionOk NONE = (e) -> {
  };

  /** @see #getId() */
  String ACTION_ID = "OK";

  @Override
  default String getId() {

    return ACTION_ID;
  }

  /**
   * @param action the {@link UiActionOk} to get null-safe. May be {@code null}.
   * @return a the given {@link UiActionOk} if not {@code null} or {@link #NONE} otherwise.
   */
  static UiActionOk notNull(UiActionOk action) {

    if (action == null) {
      return NONE;
    }
    return action;
  }

}
