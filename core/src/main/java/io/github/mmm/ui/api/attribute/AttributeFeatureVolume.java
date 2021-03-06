/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write attributes of a media player.
 *
 * @since 1.0.0
 */
public abstract interface AttributeFeatureVolume {

  /**
   * This method gets the volume of this object. Please note that the actual volume might be influenced by the mixer of
   * the operating system. This is just a relative scale to the system volume.
   *
   * @return the volume in the range from <code>0.0</code> (mute) to <code>1.0</code> (maximum).
   * @see #isMuted()
   */
  double getVolume();

  /**
   * @param volume is the new value of {@link #getVolume()}. If negative, set to {@code 0} and if greater than {@code 1}
   *        set to {@code 1}.
   */
  void setVolume(double volume);

  /**
   * @return {@code true} if muted (audio is suppressed without {@link #setVolume(double) setting volume} to {@code 0}
   *         so the {@link #getVolume() volume} is not lost), {@code false} otherwise.
   */
  boolean isMuted();

  /**
   * @param muted the new value of {@link #isMuted()}.
   */
  void setMuted(boolean muted);

  /**
   * Sets {@link #isMuted() mute} to {@code true}.
   */
  default void mute() {

    setMuted(true);
  }

  /**
   * Sets {@link #isMuted() mute} to {@code false}.
   */
  default void unmute() {

    setMuted(false);
  }

}
