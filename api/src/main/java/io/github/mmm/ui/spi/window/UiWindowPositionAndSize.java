/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.window;

import io.github.mmm.ui.attribute.AttributeWritePositionRange;
import io.github.mmm.ui.attribute.AttributeWriteSizeRange;
import io.github.mmm.ui.datatype.UiSize;

/**
 * Abstract base implementation for position, size and controls related attributes of
 * {@link io.github.mmm.ui.widget.window.UiAbstractWindow} or {@link io.github.mmm.ui.widget.window.UiChildWindow}.
 *
 * @since 1.0.0
 */
public abstract class UiWindowPositionAndSize implements AttributeWritePositionRange, AttributeWriteSizeRange {

  /** @see #getX() */
  protected double x;

  /** @see #getY() */
  protected double y;

  /** @see #getMinX() */
  protected double minX;

  /** @see #getMinY() */
  protected double minY;

  /** @see #getMaxX() */
  protected double maxX;

  /** @see #getMaxY() */
  protected double maxY;

  /** @see #getWidth() */
  protected double width;

  /** @see #getHeight() */
  protected double height;

  /** @see #getMinWidth() */
  protected double minWidth;

  /** @see #getMinHeight() */
  protected double minHeight;

  /** @see #getMaxWidth() */
  protected double maxWidth;

  /** @see #getMaxHeight() */
  protected double maxHeight;

  /**
   * The constructor.
   */
  public UiWindowPositionAndSize() {

    this.x = -1;
    this.y = -1;
    this.maxX = Integer.MAX_VALUE;
    this.maxY = Integer.MAX_VALUE;
    this.minWidth = 200;
    this.maxWidth = Integer.MAX_VALUE;
    this.minHeight = 200;
    this.maxHeight = Integer.MAX_VALUE;
  }

  @Override
  public double getWidthInPixel() {

    return this.width;
  }

  @Override
  public void setWidthInPixel(double width) {

    this.width = clipSize(width);
  }

  @Override
  public void setWidth(UiSize width) {

    setWidthInPixel(UiSize.getSafe(width).toPixel(getMaxScreenWidth()));
  }

  @Override
  public double getHeightInPixel() {

    return this.height;
  }

  @Override
  public void setHeightInPixel(double height) {

    this.height = clipSize(height);
  }

  @Override
  public void setHeight(UiSize height) {

    setHeightInPixel(UiSize.getSafe(height).toPixel(getMaxScreenHeight()));
  }

  @Override
  public void setSizeInPixel(double width, double height) {

    this.width = width;
    this.height = height;
  }

  @Override
  public void setSize(UiSize width, UiSize height) {

    setSizeInPixel(UiSize.getSafe(width).toPixel(getMaxScreenWidth()),
        UiSize.getSafe(height).toPixel(getMaxScreenHeight()));
  }

  @Override
  public double getMinWidth() {

    return this.minWidth;
  }

  @Override
  public void setMinWidth(double minWidth) {

    this.minWidth = clipSize(minWidth);
  }

  @Override
  public double getMaxWidth() {

    return this.maxWidth;
  }

  @Override
  public void setMaxWidth(double maxWidth) {

    this.maxWidth = clipSize(maxWidth);
  }

  @Override
  public double getMinHeight() {

    return this.minHeight;
  }

  @Override
  public void setMinHeight(double minHeight) {

    this.minHeight = clipSize(minHeight);
  }

  @Override
  public double getMaxHeight() {

    return this.maxHeight;
  }

  @Override
  public void setMaxHeight(double maxHeight) {

    this.maxHeight = clipSize(maxHeight);
  }

  @Override
  public double getX() {

    return this.x;
  }

  @Override
  public void setX(double x) {

    this.x = x;
  }

  @Override
  public double getY() {

    return this.y;
  }

  @Override
  public void setY(double y) {

    this.y = y;
  }

  @Override
  public void setPosition(double x, double y) {

    this.x = x;
    this.y = y;
  }

  @Override
  public double getMinX() {

    return this.minX;
  }

  @Override
  public void setMinX(double minX) {

    this.minX = clipZero(minX);
  }

  @Override
  public double getMaxX() {

    return this.maxX;
  }

  @Override
  public void setMaxX(double maxX) {

    this.maxX = clipMax(maxX);
  }

  @Override
  public double getMinY() {

    return this.minY;
  }

  @Override
  public void setMinY(double minY) {

    this.minY = clipZero(minY);
  }

  @Override
  public double getMaxY() {

    return this.maxY;
  }

  @Override
  public void setMaxY(double maxY) {

    this.maxY = clipMax(maxY);
  }

  /**
   * @return the current maximim screen width.
   */
  protected abstract double getMaxScreenWidth();

  /**
   * @return the current maximum screen height.
   */
  protected abstract double getMaxScreenHeight();

  /**
   * Initializes the position and size. If neither of those is set, size will be set to a quarter of the screen (half of
   * screen width and height) and window is centered on the screen.
   *
   * @param force {@code true} to always update {@link #getX() X} and {@link #getY() Y} to center the window on the
   *        screen, {@code false} to only update {@link #getX() X} and {@link #getY() Y} in case they are uninitialized
   *        ({@code -1}).
   */
  public void centerOnScreen(boolean force) {

    double screenWidth = getMaxScreenWidth();
    double screenHeigth = getMaxScreenHeight();
    double w = getWidthInPixel();
    if ((w < 10) || Double.isNaN(w)) {
      w = screenWidth / 2;
      setWidthInPixel(w);
    }
    double h = getHeightInPixel();
    if ((h < 10) || Double.isNaN(h)) {
      h = screenHeigth / 2;
      setWidthInPixel(h);
    }
    if (force || (this.x < 0)) {
      setX((screenWidth - w) / 2);
    }
    if (force || (this.y < 0)) {
      setY((screenHeigth - h) / 2);
    }
  }

  /**
   * @param size the width or height to clip.
   * @return the maximum of the given {@code size} and {@code 100}.
   */
  protected static double clipSize(double size) {

    if (size < 100) {
      return 100;
    }
    return size;
  }

  /**
   * @param pos the position value.
   * @return the maximum of the given {@code pos} and {@code 0}.
   */
  protected static double clipZero(double pos) {

    if (pos < 0) {
      return 0;
    }
    return pos;
  }

  /**
   * @param max the maximum value.
   * @return the given {@code max} clipped to the range from {@code 0} to {@link Integer#MAX_VALUE}.
   */
  protected static double clipMax(double max) {

    if ((max < 0) || (max > Integer.MAX_VALUE)) {
      return Integer.MAX_VALUE;
    }
    return max;
  }

}
