/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read and write the size of an object in {@link io.github.mmm.ui.datatype.UiSizeUnit#PIXEL pixel}.
 *
 * @since 1.0.0
 */
public interface AttributeWriteSizeInPixel extends AttributeReadSize {

  /**
   * @param width the new {@link #getWidthInPixel() width in pixel}.
   */
  void setWidthInPixel(double width);

  /**
   * @param height the new {@link #getHeightInPixel() height in pixel}.
   */
  void setHeightInPixel(double height);

  /**
   * @param width the new {@link #getWidthInPixel() width in pixel}.
   * @param height the new {@link #getHeightInPixel() height in pixel}.
   */
  default void setSizeInPixel(double width, double height) {

    setWidthInPixel(width);
    setHeightInPixel(height);
  }

}
