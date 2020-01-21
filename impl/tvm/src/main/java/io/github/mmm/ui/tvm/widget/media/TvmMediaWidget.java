/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.media;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLMediaElement;
import org.teavm.jso.dom.html.HTMLSourceElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiMedia;
import io.github.mmm.ui.datatype.UiMediaPreview;
import io.github.mmm.ui.datatype.UiMediaSource;
import io.github.mmm.ui.datatype.UiMediaTrack;
import io.github.mmm.ui.tvm.widget.TvmActiveWidget;
import io.github.mmm.ui.widget.media.UiMediaWidget;

/**
 * Implementation of {@link UiMediaWidget} using TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmMediaWidget<W extends HTMLMediaElement> extends TvmActiveWidget<W> implements UiMediaWidget {

  private static final String ATR_POSTER = "poster";

  private UiMedia media;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmMediaWidget(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  public UiMedia getMedia() {

    return this.media;
  }

  @Override
  public void setMedia(UiMedia media) {

    this.media = media;
    setMedia(this.widget, media);
  }

  /**
   * @param mediaElement the {@link HTMLMediaElement}.
   * @param media the {@link UiMedia} to apply.
   */
  protected void setMedia(HTMLMediaElement mediaElement, UiMedia media) {

    mediaElement.pause();
    removeAllChildren(mediaElement);
    UiMediaPreview preview = null;
    if (media != null) {
      preview = media.getPreview();
      HTMLDocument document = mediaElement.getOwnerDocument();
      for (UiMediaSource source : media.getSources()) {
        HTMLSourceElement sourceElement = document.createElement("source").cast();
        sourceElement.setSrc(source.getSource());
        String mimetype = source.getMimetype();
        if (mimetype != null) {
          sourceElement.setType(mimetype);
        }
        String language = source.getLanguage();
        if (language != null) {
          sourceElement.setLang(language);
        }
        mediaElement.appendChild(sourceElement);
      }
      for (UiMediaTrack track : media.getTracks()) {
        HTMLElement trackElement = document.createElement("track");
        trackElement.setAttribute("src", track.getSource());
        String kind = track.getKind();
        if (kind != null) {
          trackElement.setAttribute("kind", kind);
        }
        String language = track.getLanguage();
        if (language != null) {
          trackElement.setAttribute("srclang", language);
        }
        mediaElement.appendChild(trackElement);
      }
    }
    if (preview == null) {
      mediaElement.removeAttribute(ATR_POSTER);
    } else {
      mediaElement.setAttribute(ATR_POSTER, preview.getSource());
    }
    mediaElement.load();
  }

  @Override
  public boolean isPlaying() {

    if (this.widget.isPaused()) {
      return false;
    } else if (this.widget.isEnded()) {
      return false;
    }
    return true;
  }

  @Override
  public void setPlaying(boolean playing) {

    if (playing) {
      this.widget.play();
    } else {
      this.widget.pause();
    }
  }

  @Override
  public double getVolume() {

    return this.widget.getVolume();
  }

  @Override
  public void setVolume(double volume) {

    this.widget.setVolume((float) volume);
  }

  @Override
  public boolean isMuted() {

    return this.widget.isMuted();
  }

  @Override
  public void setMuted(boolean mute) {

    this.widget.setMuted(mute);
  }

  @Override
  public double getPosition() {

    return this.widget.getCurrentTime();
  }

  @Override
  public void setPosition(double position) {

    this.widget.setCurrentTime(position);
  }

  @Override
  public double getDuration() {

    double duration = this.widget.getDuration();
    if (!Double.isFinite(duration)) {
      return 0;
    }
    return duration;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    // not supported by HTML
  }

}
