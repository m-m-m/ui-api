/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to {@link #isResizable() read} and {@link #setResizable(boolean) write} the {@link #isResizable() resizable
 * flag} of an object.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteResizable {

  /**
   * @return {@code true} if this object can be {@link AttributeWriteSizeInPixel#setSizeInPixel(double, double) resized}
   *         by the end-user, {@code false} otherwise.
   */
  boolean isResizable();

  /**
   * @param resizable is the new value of {@link #isResizable()}.
   */
  void setResizable(boolean resizable);

}
