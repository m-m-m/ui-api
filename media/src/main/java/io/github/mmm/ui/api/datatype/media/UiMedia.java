/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.media;

import io.github.mmm.ui.api.impl.UiMediaImpl;

/**
 * Datatype representing a media.
 *
 * @since 1.0.0
 * @see io.github.mmm.ui.api.widget.media.UiMediaWidget#setMedia(UiMedia)
 * @see io.github.mmm.ui.api.widget.media.UiMediaPlayer
 */
public interface UiMedia {

  /**
   * @return the {@link UiMediaType}. May not be {@code null}.
   */
  UiMediaType getType();

  /**
   * @return the {@link UiMediaPreview}. May be {@code null} if no preview is defined.
   */
  UiMediaPreview getPreview();

  /**
   * @return the {@link Iterable} of {@link UiMediaSource}s. Has to contain at least one entry.
   */
  Iterable<UiMediaSource> getSources();

  /**
   * @return the {@link Iterable} of {@link UiMediaTrack}s. May be empty.
   */
  Iterable<UiMediaTrack> getTracks();

  /**
   * @param sources the {@link UiMediaSource}s. Has to be at least one.
   * @return the {@link UiMedia} instance with {@link UiMediaType#VIDEO}.
   */
  static UiMedia ofVideo(UiMediaSource... sources) {

    return ofVideo(sources, null, null);
  }

  /**
   * @param sources the {@link UiMediaSource}s. Has to be at least one.
   * @param tracks the {@link UiMediaTrack}s.
   * @param previewSource the {@link UiMediaPreview#getUrl() source} of the {@link #getPreview() preview}.
   * @return the {@link UiMedia} instance with {@link UiMediaType#VIDEO}.
   */
  static UiMedia ofVideo(UiMediaSource[] sources, UiMediaTrack[] tracks, String previewSource) {

    return new UiMediaImpl(UiMediaType.VIDEO, sources, tracks, UiMediaPreview.of(previewSource));
  }

  /**
   * @param sources the {@link UiMediaSource}s. Has to be at least one.
   * @return the {@link UiMedia} instance with {@link UiMediaType#AUDIO}.
   */
  static UiMedia ofAudio(UiMediaSource... sources) {

    return ofAudio(sources, null, null);
  }

  /**
   * @param sources the {@link UiMediaSource}s. Has to be at least one.
   * @param tracks the {@link UiMediaTrack}s.
   * @return the {@link UiMedia} instance with {@link UiMediaType#AUDIO}.
   */
  static UiMedia ofAudio(UiMediaSource[] sources, UiMediaTrack[] tracks) {

    return ofAudio(sources, tracks, null);
  }

  /**
   * @param sources the {@link UiMediaSource}s. Has to be at least one.
   * @param tracks the {@link UiMediaTrack}s.
   * @param previewSource the {@link UiMediaPreview#getUrl() source} of the {@link #getPreview() preview}.
   * @return the {@link UiMedia} instance with {@link UiMediaType#AUDIO}.
   */
  static UiMedia ofAudio(UiMediaSource[] sources, UiMediaTrack[] tracks, String previewSource) {

    return new UiMediaImpl(UiMediaType.AUDIO, sources, tracks, UiMediaPreview.of(previewSource));
  }

}
