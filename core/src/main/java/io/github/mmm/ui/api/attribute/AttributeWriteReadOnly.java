/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.widget.UiLabel;

/**
 * Interface to {@link #isReadOnly() read} and {@link #setReadOnly(boolean) write} the {@link #isReadOnly() read-only
 * flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteReadOnly {

  /**
   * @return {@code true} if this widget is read-only (value can not be edited by the user and is displayed as view only
   *         like a label), {@code false} otherwise. The read-only flag is different from
   *         {@link AttributeWriteEnabled#isEnabled() enabled} as a read-only widget is not grayed out but rather
   *         visualizes its value as an output (like a label).
   */
  default boolean isReadOnly() {

    return true;
  }

  /**
   * Switches this widget between view (read-only {@code true}) and edit (read-only {@code false}) mode. This may also
   * have effects such that a {@link io.github.mmm.ui.api.widget.panel.UiButtonPanel} is showing a "Save" button only in
   * edit mode, while it shows an "Edit" button in read-only mode that switches to edit mode.<br>
   * A {@link io.github.mmm.ui.api.widget.composite.UiComposite} will propagate the read-only state to all its children
   * when this method is called. Please note that several widgets such as {@link UiLabel} are always read-only. In such
   * case this method will have no effect.
   *
   * @param readOnly the new value of {@link #isReadOnly()}.
   */
  void setReadOnly(boolean readOnly);
}
