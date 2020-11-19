/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getSelection() read} and {@link #setSelection(Object) write} the (single-){@link #getSelection()
 * selection}.
 *
 * @param <V> type of the elements to select.
 * @since 1.0.0
 */
public abstract interface AttributeWriteSelection<V> extends AttributeReadSelection<V> {

  /**
   * @param selection is the new element to select.
   * @see #getSelection()
   */
  void setSelection(V selection);

}
