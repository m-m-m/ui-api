/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.img;

import io.github.mmm.ui.api.attribute.AttributeWriteSize;
import io.github.mmm.ui.api.attribute.AttributeWriteSource;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * A regular {@link UiAbstractImage image} provided from a {@link #getSource() source URI}.
 *
 * @since 1.0.0
 */
public interface UiImage extends UiAbstractImage, AttributeWriteSource, AttributeWriteSize, UiNativeWidget {

  /**
   * @param source the {@link UiImage#getSource() source}.
   * @return the new {@link UiImage}.
   */
  static UiImage of(String source) {

    UiImage widget = UiWidgetFactoryNative.get().create(UiImage.class);
    widget.setSource(source);
    return widget;
  }
}
