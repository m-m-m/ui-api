/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read the {@link #isMultiSelection() multi-selection flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadMultiSelection {

  /**
   * @return {@code true} to allow {@link AttributeReadSelections#getSelections() multi-selection}, {@code false} to
   *         allow only {@link AttributeReadSelection#getSelection() single-selection}.
   */
  boolean isMultiSelection();

}
