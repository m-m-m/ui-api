/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.media.UiMediaPlayer;
import io.github.mmm.ui.widget.media.UiMediaWidget;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * Implementation of {@link UiMediaWidget} using JavaFx.
 *
 * @since 1.0.0
 */
public class FxMediaPlayer extends FxMediaWidget<MediaView> implements UiMediaPlayer {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMediaPlayer(UiContext context) {

    super(context, new MediaView());
  }

  @Override
  protected void updateMediaPlayer(MediaPlayer player) {

    super.updateMediaPlayer(player);
    this.widget.setMediaPlayer(player);
  }

}
