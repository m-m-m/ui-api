/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getSelection() read} the {@link #getSelection() single-selection}.
 *
 * @param <V> type of the elements to select.
 * @since 1.0.0
 */
public abstract interface AttributeReadSelection<V> {

  /**
   * @return the currently selected element. May be {@code null} if no element is selected.
   * @see AttributeReadSelections#getSelections()
   */
  V getSelection();

}
