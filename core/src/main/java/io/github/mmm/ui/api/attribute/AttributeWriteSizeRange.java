/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write min/max ranges for the {@link #setSizeInPixel(double, double) size}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteSizeRange extends AttributeWriteSize {

  /**
   * @return the minimum allowed value of {@link #getWidthInPixel() width in pixel}. Will be {@code 200} by default.
   *         Should be less or equal to {@link #getMaxWidth() maxWidth}.
   */
  double getMinWidth();

  /**
   * @param minWidth the new value of {@link #getMinWidth() minWidth}. Will not affect current {@link #getWidth() width}
   *        but only apply to resizing by the end-user.
   */
  void setMinWidth(double minWidth);

  /**
   * @return the maximum allowed value of {@link #getWidthInPixel() width in pixel}. Will be {@link Integer#MAX_VALUE}
   *         by default (unbounded) and is automatically clipped to the available width (of the
   *         {@link io.github.mmm.ui.api.UiScreen} or main window). Should be greater or equal to {@link #getMinWidth()
   *         minWidth}.
   */
  double getMaxWidth();

  /**
   * @param maxWidth the new value of {@link #getMaxWidth() maxWidth}. Will not affect current {@link #getWidth() width}
   *        but only apply to resizing by the end-user.
   */
  void setMaxWidth(double maxWidth);

  /**
   * @param minWidth the new value of {@link #getMinWidth() minWidth}. Will not affect current {@link #getWidth() width}
   *        but only apply to resizing by the end-user.
   * @param maxWidth the new value of {@link #getMaxWidth() maxWidth}. Will not affect current {@link #getWidth() width}
   *        but only apply to resizing by the end-user.
   */
  default void setWidthRange(double minWidth, double maxWidth) {

    setMinWidth(minWidth);
    setMaxWidth(maxWidth);
  }

  /**
   * @return the minimum allowed value of {@link #getHeightInPixel() height in pixel}. Will be {@code 200} by default.
   *         Should be less or equal to {@link #getMaxHeight() maxHeight}.
   */
  double getMinHeight();

  /**
   * @param minHeight the new value of {@link #getMinHeight() minHeight}. Will not affect current {@link #getHeight()
   *        height} but only apply to resizing by the end-user.
   */
  void setMinHeight(double minHeight);

  /**
   * @return the maximum allowed value of {@link #getHeightInPixel() height in pixel}. Will be {@link Integer#MAX_VALUE}
   *         by default (unbounded) and is automatically clipped to the available height (of the
   *         {@link io.github.mmm.ui.api.UiScreen} or main window). Should be greater or equal to {@link #getMinHeight()
   *         minHeight}.
   */
  double getMaxHeight();

  /**
   * @param maxHeight the new value of {@link #getMaxHeight() maxHeight}. Will not affect current {@link #getHeight()
   *        height} but only apply to resizing by the end-user.
   */
  void setMaxHeight(double maxHeight);

  /**
   * @param minHeight the new value of {@link #getMinHeight() minHeight}. Will not affect current {@link #getHeight()
   *        height} but only apply to resizing by the end-user.
   * @param maxHeight the new value of {@link #getMaxHeight() maxHeight}. Will not affect current {@link #getHeight()
   *        height} but only apply to resizing by the end-user.
   */
  default void setHeightRange(double minHeight, double maxHeight) {

    setMinHeight(minHeight);
    setMaxHeight(maxHeight);
  }

}
