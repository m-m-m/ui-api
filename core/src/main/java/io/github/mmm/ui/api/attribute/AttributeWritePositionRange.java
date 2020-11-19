/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write the minimum and maximum values for the {@link #setPosition(double, double) position}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWritePositionRange extends AttributeWritePosition {

  /**
   * @return the minimum allowed value of {@link #getX() X}. Will be {@code 0} by default (unbounded). Should be less or
   *         equal to {@link #getMaxX() maxX}.
   */
  double getMinX();

  /**
   * @param minX the new value of {@link #getMinX() minX}. Will not affect current {@link #getX() X} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  void setMinX(double minX);

  /**
   * @return the maximum allowed value of {@link #getX() X}. Will be {@link Integer#MAX_VALUE} by default (unbounded)
   *         and is automatically clipped to the available width (of the {@link io.github.mmm.ui.api.UiScreen} or main
   *         window). Should be greater or equal to {@link #getMinX() minX}.
   */
  double getMaxX();

  /**
   * @param maxX the new value of {@link #getMaxX() maxX}. Will not affect current {@link #getX() X} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  void setMaxX(double maxX);

  /**
   * @param minX the new value of {@link #getMinX() minX}. Will not affect current {@link #getX() X} coordinate but only
   *        apply to moving and resizing by the end-user.
   * @param maxX the new value of {@link #getMaxX() maxX}. Will not affect current {@link #getX() X} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  default void setXRange(double minX, double maxX) {

    setMinX(minX);
    setMaxX(maxX);
  }

  /**
   * @return the minimum allowed value of {@link #getY() Y}. Will be {@code 0} by default (unbounded). Should be less or
   *         equal to {@link #getMaxY() maxY}.
   */
  double getMinY();

  /**
   * @param minY the new value of {@link #getMinY() minY}. Will not affect current {@link #getY() Y} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  void setMinY(double minY);

  /**
   * @return the maximum allowed value of {@link #getY() Y}. Will be {@link Integer#MAX_VALUE} by default (unbounded)
   *         and is automatically clipped to the available width (of the {@link io.github.mmm.ui.api.UiScreen} or main
   *         window). Should be greater or equal to {@link #getMinY() minY}.
   */
  double getMaxY();

  /**
   * @param maxY the new value of {@link #getMaxY() maxY}. Will not affect current {@link #getY() Y} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  void setMaxY(double maxY);

  /**
   * @param minY the new value of {@link #getMinY() minY}. Will not affect current {@link #getY() Y} coordinate but only
   *        apply to moving and resizing by the end-user.
   * @param maxY the new value of {@link #getMaxY() maxY}. Will not affect current {@link #getY() Y} coordinate but only
   *        apply to moving and resizing by the end-user.
   */
  default void setYRange(double minY, double maxY) {

    setMinY(minY);
    setMaxY(maxY);
  }

}
