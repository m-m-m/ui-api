/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.datatype.UiSize;

/**
 * Interface to read the size as {@link #getWidth() width} and {@link #getHeight() height}.
 *
 * @since 1.0.0
 */
public interface AttributeReadSize {

  /**
   * @return the width of this object in pixels.<br>
   *         <b>NOTE:</b> The result will typically be an {@code int} value. However, to be compatible with
   *         {@link io.github.mmm.ui.api.datatype.UiSize#getAmount()} and with some underlying native toolkits we use
   *         {@code double}. You may cast the result to {@code int}.
   */
  double getWidthInPixel();

  /**
   * @return the height of this object in pixels.<br>
   *         <b>NOTE:</b> The result will typically be an {@code int} value. However, to be compatible with
   *         {@link io.github.mmm.ui.api.datatype.UiSize#getAmount()} and with some underlying native toolkits we use
   *         {@code double}. You may cast the result to {@code int}.
   */
  double getHeightInPixel();

  /**
   * @return the width of this object. Will be {@link UiSize#AUTO} if undefined.
   */
  default UiSize getWidth() {

    return UiSize.ofPixel(getWidthInPixel());
  }

  /**
   * @return the height of this object. Will be {@link UiSize#AUTO} if undefined.
   */
  default UiSize getHeight() {

    return UiSize.ofPixel(getHeightInPixel());
  }

}
