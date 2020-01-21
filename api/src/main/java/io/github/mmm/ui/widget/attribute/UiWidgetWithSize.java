/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.attribute.AttributeReadSizeInPixel;
import io.github.mmm.ui.datatype.UiLength;
import io.github.mmm.ui.datatype.UiLengthUnit;
import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #setSize(UiLength, UiLength) size} of {@link #getWidth() width} and
 * {@link #getHeight() height}.
 *
 * @since 1.0.0
 */
public interface UiWidgetWithSize extends UiWidget, AttributeReadSizeInPixel {

  /**
   * @return the width of this widget. Will be {@link UiLength#ZERO} if undefined (NOT set).
   */
  UiLength getWidth();

  @Override
  default double getWidthInPixel() {

    return getWidth().toPixel(getContext().getScreen().getWidthInPixel());
  }

  /**
   * @param width the new {@link #getWidth() width}.
   */
  void setWidth(UiLength width);

  /**
   * @return the height of this widget. Will be {@link UiLength#ZERO} if undefined (NOT set).
   */
  UiLength getHeight();

  @Override
  default double getHeightInPixel() {

    return getHeight().toPixel(getContext().getScreen().getHeightInPixel());
  }

  /**
   * @param height the new {@link #getHeight() height}.
   */
  void setHeight(UiLength height);

  /**
   * @param width the new {@link #getWidth() width} of the widget.
   * @param height the new {@link #getHeight() height} of the widget.
   */
  default void setSize(UiLength width, UiLength height) {

    setWidth(width);
    setHeight(height);
  }

  /**
   * @param width the new {@link #getWidth() width} of the widget.
   * @param height the new {@link #getHeight() height} of the widget.
   * @param unit the {@link UiLengthUnit unit} of {@code width} and {@code height}.
   */
  default void setSize(double width, double height, UiLengthUnit unit) {

    setSize(unit.newLength(width), unit.newLength(height));
  }

}
