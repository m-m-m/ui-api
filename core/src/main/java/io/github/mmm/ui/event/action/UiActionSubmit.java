/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>submit</em>. It will acknowledge the current choice or change and submit data to the server.
 * It is more generic than {@link UiActionSave} and may be used when data can not be modified afterwards.
 *
 * @see UiActionConfirm
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionSubmit extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "submit";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
