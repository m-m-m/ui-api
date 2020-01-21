/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * This interface gives read access to the size of an object in {@link io.github.mmm.ui.datatype.UiLengthUnit#PIXEL
 * pixel}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadSizeInPixel {

  /**
   * @return the width of this object in pixels.<br>
   *         <b>NOTE:</b> The result will typically be an {@code int} value. However, to be compatible with
   *         {@link io.github.mmm.ui.datatype.UiLength#getAmount()} and with some underlying native toolkits we use
   *         {@code double}. You may cast the result to {@code int}.
   */
  double getWidthInPixel();

  /**
   * @return the height of this object in pixels.<br>
   *         <b>NOTE:</b> The result will typically be an {@code int} value. However, to be compatible with
   *         {@link io.github.mmm.ui.datatype.UiLength#getAmount()} and with some underlying native toolkits we use
   *         {@code double}. You may cast the result to {@code int}.
   */
  double getHeightInPixel();

}
