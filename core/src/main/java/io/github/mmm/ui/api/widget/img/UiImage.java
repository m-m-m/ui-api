/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.img;

import io.github.mmm.ui.api.attribute.AttributeWriteSize;
import io.github.mmm.ui.api.attribute.AttributeWriteUrl;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * A regular {@link UiAbstractImage image} provided from a {@link #getUrl() source URI}.
 *
 * @since 1.0.0
 */
public interface UiImage extends UiAbstractImage, AttributeWriteUrl, AttributeWriteSize, UiNativeWidget {

  /**
   * @param url the {@link #getUrl() URL}.
   * @return the new {@link UiImage}.
   */
  static UiImage of(String url) {

    UiImage widget = UiWidgetFactoryNative.get().create(UiImage.class);
    widget.setUrl(url);
    return widget;
  }
}
