/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to handle all features related to playback (of audio or video).
 *
 * @since 1.0.0
 */
public abstract interface AttributeFeaturePlayback {

  /**
   * @return {@code true} if the media is currently playing, {@code false} otherwise (if paused or nothing to play).
   */
  boolean isPlaying();

  /**
   * @param playing is the new value of {@link #isPlaying()}. Use {@code true} to play or resume and {@code false} to
   *        pause. Please note that if no media is present or it is invalid, it will not get into {@link #isPlaying()
   *        playing} state even after providing {@code true}
   */
  void setPlaying(boolean playing);

  /**
   * Start or resume the media.
   *
   * @see #setPlaying(boolean)
   */
  default void play() {

    setPlaying(true);
  }

  /**
   * Pause the media.
   *
   * @see #setPlaying(boolean)
   */
  default void pause() {

    setPlaying(false);
  }

}
