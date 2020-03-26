/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>save</em>. It will save the current changes to make them persistent.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionSave extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "save";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
