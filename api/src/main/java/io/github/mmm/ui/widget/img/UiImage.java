/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.img;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteSize;
import io.github.mmm.ui.attribute.AttributeWriteSource;
import io.github.mmm.ui.widget.UiAtomicWidget;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAtomicWidget} for an image.
 *
 * @since 1.0.0
 */
public interface UiImage extends UiAbstractImage, AttributeWriteSource, AttributeWriteSize, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param source the {@link UiImage#getSource() source}.
   * @return the new {@link UiImage}.
   */
  static UiImage of(UiContext context, String source) {

    UiImage widget = context.create(UiImage.class);
    widget.setSource(source);
    return widget;
  }
}
