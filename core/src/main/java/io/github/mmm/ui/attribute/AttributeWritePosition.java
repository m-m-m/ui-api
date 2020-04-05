/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read and {@link #setPosition(double, double) write} a position.
 *
 * @since 1.0.0
 */
public interface AttributeWritePosition extends AttributeReadPosition {

  /**
   * @param x the new {@link #getX() position on the x-axis}.
   */
  void setX(double x);

  /**
   * @param y the new {@link #getY() position on the y-axis}.
   */
  void setY(double y);

  /**
   * This method sets the position of the widget.
   *
   * @param x the new {@link #getX() position on the x-axis}.
   * @param y the new {@link #getY() position on the y-axis}.
   */
  default void setPosition(double x, double y) {

    setX(x);
    setY(y);
  }

}
