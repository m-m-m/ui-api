/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event.action;

/**
 * {@link UiAction} for <em>open</em>. It will allow the user open some object or data. Especially suitable to open an
 * attachment like a PDF.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionOpen extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "open";

  @Override
  default String getId() {

    return ACTION_ID;
  }
}
