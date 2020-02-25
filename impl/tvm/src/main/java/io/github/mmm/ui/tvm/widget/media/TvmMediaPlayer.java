/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.media;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiMedia;
import io.github.mmm.ui.datatype.UiMediaType;
import io.github.mmm.ui.tvm.widget.TvmActiveWidget;
import io.github.mmm.ui.widget.media.UiMediaPlayer;

/**
 * Implementation of {@link UiMediaPlayer} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMediaPlayer extends TvmActiveWidget<HTMLElement> implements UiMediaPlayer {

  private TvmAudioPlayer audio;

  private TvmVideoPlayer video;

  private TvmMediaWidget<?> activeMedia;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMediaPlayer(UiContext context) {

    super(context, newElement("ui-mplayer"));
  }

  private TvmAudioPlayer getAudio() {

    if (this.audio == null) {
      this.audio = new TvmAudioPlayer(this.context);
      this.audio.getWidget().setControls(true);
      getTopWidget().appendChild(this.audio.getTopWidget());
      this.activeMedia = this.audio;
    }
    return this.audio;
  }

  private TvmVideoPlayer getVideo() {

    if (this.video == null) {
      this.video = new TvmVideoPlayer(this.context);
      this.video.getWidget().setControls(true);
      getTopWidget().appendChild(this.video.getTopWidget());
      this.activeMedia = this.video;
    }
    return this.video;
  }

  private void activate(UiMediaType type, UiMedia media) {

    TvmMediaWidget<?> newActiveMedia;
    if (type == UiMediaType.AUDIO) {
      newActiveMedia = getAudio();
    } else if (type == UiMediaType.VIDEO) {
      newActiveMedia = getVideo();
    } else {
      newActiveMedia = null;
    }
    if (this.activeMedia != newActiveMedia) {
      if (this.activeMedia != null) {
        this.activeMedia.setMedia(null);
        this.activeMedia.setVisible(false);
      }
      this.activeMedia = newActiveMedia;
    }
    if (this.activeMedia != null) {
      this.activeMedia.setMedia(media);
      this.activeMedia.setVisible(true);
    }
  }

  @Override
  public UiMedia getMedia() {

    if (this.activeMedia == null) {
      return null;
    }
    return this.activeMedia.getMedia();
  }

  @Override
  public void setMedia(UiMedia media) {

    if (media == null) {
      if (this.activeMedia != null) {
        this.activeMedia.setMedia(null);
      }
      return;
    }
    activate(media.getType(), media);
  }

  @Override
  public boolean isPlaying() {

    if (this.activeMedia != null) {
      return this.activeMedia.isPlaying();
    }
    return false;
  }

  @Override
  public void setPlaying(boolean playing) {

    if (this.activeMedia != null) {
      this.activeMedia.setPlaying(playing);
    }
  }

  @Override
  public double getVolume() {

    if (this.activeMedia != null) {
      return this.activeMedia.getVolume();
    }
    return 0;
  }

  @Override
  public void setVolume(double volume) {

    if (this.activeMedia != null) {
      this.activeMedia.setVolume(volume);
    }
  }

  @Override
  public boolean isMuted() {

    if (this.activeMedia != null) {
      return this.activeMedia.isMuted();
    }
    return false;
  }

  @Override
  public void setMuted(boolean muted) {

    if (this.activeMedia != null) {
      this.activeMedia.setMuted(muted);
    }
  }

  @Override
  public double getPosition() {

    if (this.activeMedia != null) {
      return this.activeMedia.getPosition();
    }
    return 0;
  }

  @Override
  public void setPosition(double position) {

    if (this.activeMedia != null) {
      this.activeMedia.setPosition(position);
    }
  }

  @Override
  public double getDuration() {

    if (this.activeMedia != null) {
      return this.activeMedia.getDuration();
    }
    return 0;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    if (this.activeMedia != null) {
      this.activeMedia.setEnabled(enabled);
    }
  }

}
