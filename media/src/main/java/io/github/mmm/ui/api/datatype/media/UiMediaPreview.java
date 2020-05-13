/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.media;

import io.github.mmm.ui.api.attribute.AttributeReadUrl;
import io.github.mmm.ui.api.widget.AbstractUiWidget;

/**
 * Datatype representing a preview of a {@link UiMedia}. It {@link #getUrl() points} to a preview-image (called
 * {@code poster} in HTML) .
 *
 * @since 1.0.0
 */
public final class UiMediaPreview implements AttributeReadUrl {

  private final String url;

  /**
   * The constructor.
   *
   * @param url the {@link #getUrl() URL}.
   */
  public UiMediaPreview(String url) {

    super();
    if (AbstractUiWidget.isEmpty(url)) {
      throw new IllegalArgumentException("url=" + url);
    }
    this.url = url;
  }

  @Override
  public String getUrl() {

    return this.url;
  }

  /**
   * @param url the {@link #getUrl() url}.
   * @return a new {@link UiMediaPreview} instance.
   */
  public static UiMediaPreview of(String url) {

    if ((url == null) || url.isEmpty()) {
      return null;
    }
    return new UiMediaPreview(url);
  }

}
