/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.img.UiImage;

/**
 * {@link UiWidget} with a {@link #getImage() image} (icon).
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteImage {

  /**
   * @return the {@link UiImage} of this widget (typically an icon). Will be {@code null} if not set.
   */
  UiImage getImage();

  /**
   * @param image is the new {@link #getImage() image}. May be {@code null} to remove an existing image.
   */
  void setImage(UiImage image);

}
