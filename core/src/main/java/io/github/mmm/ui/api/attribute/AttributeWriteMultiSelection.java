/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isMultiSelection() read} and {@link #setMultiSelection(boolean) write} the
 * {@link #isMultiSelection() multi-selection flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteMultiSelection extends AttributeReadMultiSelection {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for selection cells (header/body). */
  String STYLE_SELECTION = "sel";

  /**
   * @param multiSelection the new value of {@link #isMultiSelection()}. Should be set once after creation of this
   *        widget. Changing selection mode dynamically after attaching this widget and making it visible may not be
   *        supported on all platforms.
   * @see #isMultiSelection()
   */
  void setMultiSelection(boolean multiSelection);

}
