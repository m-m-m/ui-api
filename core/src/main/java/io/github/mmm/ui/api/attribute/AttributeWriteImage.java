/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.widget.img.UiAbstractImage;

/**
 * Interface to {@link #getImage() read} and {@link #setImage(UiAbstractImage) write} an {@link #getImage() image or
 * icon}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteImage {

  /**
   * @return the {@link UiAbstractImage image or icon} of this widget (typically a
   *         {@link io.github.mmm.ui.api.widget.img.UiIcon}). Will be {@code null} if not set.
   */
  UiAbstractImage getImage();

  /**
   * @param image is the new {@link #getImage() image}. May be {@code null} to remove an existing image.
   */
  void setImage(UiAbstractImage image);

}
