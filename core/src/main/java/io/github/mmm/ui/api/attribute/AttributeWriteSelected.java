/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isSelected() read} and {@link #setSelected(boolean) write} the {@link #isSelected() selected
 * flag}.
 *
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteSelected {

  /**
   * @return {@code true} if this option is selected (checked or active option), {@code false} otherwise.
   */
  boolean isSelected();

  /**
   * @param selected the new value of {@link #isSelected()}.
   */
  void setSelected(boolean selected);

}
