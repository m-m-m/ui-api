/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiAction} for <em>edit</em>. It will allow the user to edit some object or data. It may
 * {@link UiWidget#setReadOnly(boolean) set the dialog from readonly to editable} or open a popup window for editing a
 * selected object.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionEdit extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Edit";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
