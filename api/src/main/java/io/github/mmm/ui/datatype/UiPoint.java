/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 * A 2-D point.
 *
 * @since 1.0.0
 */
public final class UiPoint {

  private final double x;

  private final double y;

  /**
   * The constructor.
   *
   * @param x the {@link #getX() x coordinate}.
   * @param y the {@link #getY() y coordinate}.
   */
  public UiPoint(double x, double y) {

    super();
    this.x = x;
    this.y = y;
  }

  /**
   * @return the x coordinate (on horizontal axis from left to right).
   */
  public double getX() {

    return this.x;
  }

  /**
   * @return the y coordinate (on vertical axis from top to bottom).
   */
  public double getY() {

    return this.y;
  }

  @Override
  public String toString() {

    return "<" + this.x + "," + this.y + ">";
  }

}
