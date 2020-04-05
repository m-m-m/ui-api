/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read position as {@link #getX() X} and {@link #getY() Y} coordinates.
 *
 * @since 1.0.0
 */
public interface AttributeReadPosition {

  /**
   * @return the x position of this object as the number of pixels from the left on the x-axis (horizontally).
   */
  double getX();

  /**
   * @return the y position of this object as the number of pixels from the top on the y-axis (vertically).
   */
  double getY();

}
