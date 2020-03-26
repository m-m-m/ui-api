/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>apply</em>. It will apply something (a selection or change) to an object.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionApply extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "apply";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
