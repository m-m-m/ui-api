/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.media;

import org.teavm.jso.dom.html.HTMLVideoElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.media.UiImage;
import io.github.mmm.ui.widget.media.UiVideoPlayer;

/**
 * Implementation of {@link UiVideoPlayer} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmVideoPlayer extends TvmMediaWidget<HTMLVideoElement> implements UiVideoPlayer {

  private UiImage image;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmVideoPlayer(UiContext context) {

    super(context, newVideo());
  }

  @Override
  public UiImage getImage() {

    return this.image;
  }

  @Override
  public void setImage(UiImage image) {

    if (image == null) {
      this.widget.setPoster("");
    } else {
      this.widget.setPoster(image.getSource());
    }
    this.image = image;
  }

}
