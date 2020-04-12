/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.datatype.UiSize;
import io.github.mmm.ui.api.datatype.UiSizeUnit;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #setSize(UiSize, UiSize) size} of {@link #getWidth() width} and
 * {@link #getHeight() height}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteSize extends AttributeWriteSizeInPixel {

  /**
   * @param width the new {@link #getWidth() width}.
   */
  void setWidth(UiSize width);

  @Override
  default void setWidthInPixel(double width) {

    setWidth(UiSize.ofPixel(width));
  }

  /**
   * @param height the new {@link #getHeight() height}.
   */
  void setHeight(UiSize height);

  @Override
  default void setHeightInPixel(double height) {

    setHeight(UiSize.ofPixel(height));
  }

  /**
   * @param width the new {@link #getWidth() width}.
   * @param height the new {@link #getHeight() height}.
   */
  default void setSize(UiSize width, UiSize height) {

    setWidth(width);
    setHeight(height);
  }

  /**
   * @param width the new {@link #getWidth() width}.
   * @param height the new {@link #getHeight() height}.
   * @param unit the {@link UiSizeUnit unit} of {@code width} and {@code height}.
   */
  default void setSize(double width, double height, UiSizeUnit unit) {

    setSize(unit.newSize(width), unit.newSize(height));
  }

  @Override
  default void setSizeInPixel(double width, double height) {

    setSize(UiSize.ofPixel(width), UiSize.ofPixel(height));
  }

}
