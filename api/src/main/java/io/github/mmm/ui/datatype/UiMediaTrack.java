/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

import io.github.mmm.ui.attribute.AttributeReadLanguage;
import io.github.mmm.ui.attribute.AttributeReadSource;
import io.github.mmm.ui.spi.widget.AbstractUiWidget;

/**
 * Datatype representing a track of a {@link UiMedia}. It {@link #getSource() points} to metadata (e.g. captions).
 *
 * @since 1.0.0
 */
public final class UiMediaTrack implements AttributeReadSource, AttributeReadLanguage {

  /** Supported {@link #getKind() kind} {@value}. */
  public static final String KIND_CAPTIONS = "captions";

  private final String source;

  private final String kind;

  private final String language;

  private final String label;

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source}.
   * @param kind the {@link #getKind() kind}.
   * @param language the {@link #getLanguage() language}.
   * @param label the {@link #getLabel() label}.
   */
  public UiMediaTrack(String source, String kind, String language, String label) {

    super();
    if (AbstractUiWidget.isEmpty(source)) {
      throw new IllegalArgumentException("source=" + source);
    }
    this.source = source;
    this.kind = kind;
    this.language = language;
    this.label = label;
  }

  @Override
  public String getSource() {

    return this.source;
  }

  /**
   * @return the kind of this track (e.g. {@link #KIND_CAPTIONS captions}).
   */
  public String getKind() {

    return this.kind;
  }

  @Override
  public String getLanguage() {

    return this.language;
  }

  /**
   * @return the label with the text displayed to the end-user to choose this track.
   */
  public String getLabel() {

    return this.label;
  }

}
