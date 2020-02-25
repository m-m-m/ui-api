/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiMedia;
import io.github.mmm.ui.datatype.UiMediaSource;
import io.github.mmm.ui.datatype.UiMediaType;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import io.github.mmm.ui.widget.media.UiMediaWidget;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 * Implementation of {@link UiMediaWidget} using JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxMediaWidget<W extends Node> extends FxWidgetNode<W> implements UiMediaWidget {

  private MediaPlayer mediaPlayer;

  private UiMedia media;

  private double volume;

  private boolean muted;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxMediaWidget(UiContext context, W widget) {

    super(context, widget);
    this.volume = 0.8;
  }

  @Override
  public UiMedia getMedia() {

    return this.media;
  }

  @Override
  public void setMedia(UiMedia media) {

    if (media == this.media) {
      return;
    }
    if (this.mediaPlayer != null) {
      this.mediaPlayer.stop();
    }
    MediaPlayer player = null;
    if (media != null) {
      checkMediaType(media.getType());
      UiMediaSource source = media.getSources().iterator().next();
      Media fxMedia = new Media(source.getSource());
      player = new MediaPlayer(fxMedia);
      player.setVolume(this.volume);
    }
    this.mediaPlayer = player;
    this.media = media;
    updateMediaPlayer(player);
  }

  /**
   * @param player the new {@link MediaPlayer}.
   * @see #setMedia(UiMedia)
   */
  protected void updateMediaPlayer(MediaPlayer player) {

  }

  /**
   * @param type the {@link UiMediaType} to verify.
   */
  protected void checkMediaType(UiMediaType type) {

  }

  @Override
  public boolean isPlaying() {

    if (this.mediaPlayer == null) {
      return false;
    }
    return this.mediaPlayer.getStatus() == Status.PLAYING;
  }

  @Override
  public void setPlaying(boolean playing) {

    if (this.mediaPlayer == null) {
      return;
    }
    if (playing) {
      this.mediaPlayer.play();
    } else {
      this.mediaPlayer.stop();
    }
  }

  @Override
  public double getVolume() {

    return this.volume;
  }

  @Override
  public void setVolume(double volume) {

    if (volume == this.volume) {
      return;
    }
    if (this.mediaPlayer != null) {
      this.mediaPlayer.setVolume(volume);
    }
    this.volume = volume;
  }

  @Override
  public boolean isMuted() {

    return this.muted;
  }

  @Override
  public void setMuted(boolean muted) {

    if (this.mediaPlayer != null) {
      this.mediaPlayer.setMute(muted);
    }
    this.muted = muted;
  }

  @Override
  public double getPosition() {

    if (this.mediaPlayer != null) {
      return this.mediaPlayer.getCurrentRate();
    }
    return 0;
  }

  @Override
  public void setPosition(double position) {

    if (this.mediaPlayer != null) {
      if (this.mediaPlayer.getStatus() == Status.STOPPED) {
        this.mediaPlayer.play();
        this.mediaPlayer.pause();
      }
      Duration totalDuration = this.mediaPlayer.getTotalDuration();
      Duration seekTime = totalDuration.multiply(position);
      this.mediaPlayer.seek(seekTime);
    }
  }

  @Override
  public double getDuration() {

    if (this.mediaPlayer != null) {
      Duration totalDuration = this.mediaPlayer.getTotalDuration();
      return totalDuration.toSeconds();
    }
    return 0;
  }

}
