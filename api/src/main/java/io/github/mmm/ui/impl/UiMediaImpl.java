/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.github.mmm.ui.datatype.media.UiMedia;
import io.github.mmm.ui.datatype.media.UiMediaPreview;
import io.github.mmm.ui.datatype.media.UiMediaSource;
import io.github.mmm.ui.datatype.media.UiMediaTrack;
import io.github.mmm.ui.datatype.media.UiMediaType;

/**
 * Implementation of {@link UiMedia}.
 */
public class UiMediaImpl implements UiMedia {

  private final UiMediaType type;

  private final UiMediaPreview preview;

  private final List<UiMediaSource> sources;

  private final List<UiMediaTrack> tracks;

  /**
   * The constructor.
   *
   * @param type the {@link #getType() type}.
   * @param sources the {@link #getSources() sources}.
   * @param tracks the {@link #getTracks() tracks}.
   * @param preview the {@link #getPreview() preview}. May be {@code null}.
   */
  public UiMediaImpl(UiMediaType type, UiMediaSource[] sources, UiMediaTrack[] tracks, UiMediaPreview preview) {

    super();

    this.type = type;
    this.sources = Arrays.asList(sources);
    if (tracks == null) {
      this.tracks = Collections.emptyList();
    } else {
      this.tracks = Arrays.asList(tracks);
    }
    this.preview = preview;
  }

  @Override
  public UiMediaType getType() {

    return this.type;
  }

  @Override
  public UiMediaPreview getPreview() {

    return this.preview;
  }

  @Override
  public Iterable<UiMediaSource> getSources() {

    return this.sources;
  }

  @Override
  public Iterable<UiMediaTrack> getTracks() {

    return this.tracks;
  }

}
