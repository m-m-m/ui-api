/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.media;

import io.github.mmm.ui.attribute.AttributeReadLanguage;
import io.github.mmm.ui.attribute.AttributeReadMimetype;
import io.github.mmm.ui.attribute.AttributeReadSource;
import io.github.mmm.ui.spi.widget.AbstractUiWidget;

/**
 * Datatype representing a single source of a {@link UiMedia}. It {@link #getSource() points} to the actual content.
 *
 * @since 1.0.0
 */
public final class UiMediaSource implements AttributeReadSource, AttributeReadMimetype, AttributeReadLanguage {

  private final String source;

  private final String mimetype;

  private final String language;

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source}.
   * @param mimetype the {@link #getMimetype() mimetype}.
   */
  public UiMediaSource(String source, String mimetype) {

    this(source, mimetype, null);
  }

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source}.
   * @param mimetype the {@link #getMimetype() mimetype}.
   * @param language the {@link #getLanguage() language}.
   */
  public UiMediaSource(String source, String mimetype, String language) {

    super();
    if (AbstractUiWidget.isEmpty(source)) {
      throw new IllegalArgumentException("source=" + source);
    }
    this.source = source;
    this.mimetype = mimetype;
    this.language = language;
  }

  @Override
  public String getSource() {

    return this.source;
  }

  @Override
  public String getMimetype() {

    return this.mimetype;
  }

  @Override
  public String getLanguage() {

    return this.language;
  }

}
