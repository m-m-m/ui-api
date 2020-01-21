/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #setPosition(double, double) position} of {@link #getX() X} and {@link #getY() Y}
 * coordinates.
 *
 * @since 1.0.0
 */
public interface UiWidgetWithPosition extends UiWidget {

  /**
   * @return the x position of this widget as the number of pixels from the left on the x-axis (horizontally).
   */
  double getX();

  /**
   * @return the y position of this widget at the number of pixels from the top on the y-axia (certically).
   */
  double getY();

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
