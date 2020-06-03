/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write attributes of a media player.
 *
 * @since 1.0.0
 */
public abstract interface AttributeFeatureMedia extends AttributeFeaturePlayback, AttributeFeatureVolume {

  /**
   * @return the current position of the playback as factor in the range from {@code 0} (0%, start) to {@code 1} (100%,
   *         end).
   */
  double getPosition();

  /**
   * @param position is the new value of {@link #getPosition()}. If negative, set to {@code 0} and if greater than
   *        {@code 1} set to {@code 1}.
   */
  void setPosition(double position);

  /**
   * @return the duration of the current media in seconds. Will be {@code 0} if no media is present, media is invalid or
   *         empty.
   */
  double getDuration();

}
