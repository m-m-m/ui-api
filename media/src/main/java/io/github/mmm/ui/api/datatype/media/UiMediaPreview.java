/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.media;

import io.github.mmm.ui.api.attribute.AttributeReadSource;
import io.github.mmm.ui.spi.widget.AbstractUiWidget;

/**
 * Datatype representing a preview of a {@link UiMedia}. It {@link #getSource() points} to a preview-image (called
 * {@code poster} in HTML) .
 *
 * @since 1.0.0
 */
public final class UiMediaPreview implements AttributeReadSource {

  private final String source;

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source}.
   */
  public UiMediaPreview(String source) {

    super();
    if (AbstractUiWidget.isEmpty(source)) {
      throw new IllegalArgumentException("source=" + source);
    }
    this.source = source;
  }

  @Override
  public String getSource() {

    return this.source;
  }

  /**
   * @param source the {@link #getSource() source}.
   * @return a new {@link UiMediaPreview} instance.
   */
  public static UiMediaPreview of(String source) {

    if ((source == null) || source.isEmpty()) {
      return null;
    }
    return new UiMediaPreview(source);
  }

}
