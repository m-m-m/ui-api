/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.media;

import io.github.mmm.ui.api.attribute.AttributeReadLanguage;
import io.github.mmm.ui.api.attribute.AttributeReadMimetype;
import io.github.mmm.ui.api.attribute.AttributeReadUrl;
import io.github.mmm.ui.api.widget.AbstractUiWidget;

/**
 * Datatype representing a single source of a {@link UiMedia}. It {@link #getUrl() points} to the actual content.
 *
 * @since 1.0.0
 */
public final class UiMediaSource implements AttributeReadUrl, AttributeReadMimetype, AttributeReadLanguage {

  private final String url;

  private final String mimetype;

  private final String language;

  /**
   * The constructor.
   *
   * @param url the {@link #getUrl() URL}.
   * @param mimetype the {@link #getMimetype() mimetype}.
   */
  public UiMediaSource(String url, String mimetype) {

    this(url, mimetype, null);
  }

  /**
   * The constructor.
   *
   * @param url the {@link #getUrl() URL}.
   * @param mimetype the {@link #getMimetype() mimetype}.
   * @param language the {@link #getLanguage() language}.
   */
  public UiMediaSource(String url, String mimetype, String language) {

    super();
    if (AbstractUiWidget.isEmpty(url)) {
      throw new IllegalArgumentException("url=" + url);
    }
    this.url = url;
    this.mimetype = mimetype;
    this.language = language;
  }

  @Override
  public String getUrl() {

    return this.url;
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
