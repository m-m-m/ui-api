/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.media;

import io.github.mmm.ui.api.datatype.media.UiMedia;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiMediaWidget} that represents a media-player. It can both play audio or video {@link UiMedia media} and has
 * controls for the end-user (volume, time-bar, fullscreen, mute, etc.).
 *
 * @since 1.0.0
 */
public interface UiMediaPlayer extends UiMediaWidget, UiNativeWidget {

  /**
   * @param media the optional initial {@link UiMedia}.
   * @return the new {@link UiMediaPlayer}.
   */
  static UiMediaPlayer of(UiMedia media) {

    UiMediaPlayer widget = UiWidgetFactoryNative.get().create(UiMediaPlayer.class);
    if (media != null) {
      widget.setMedia(media);
    }
    return widget;
  }

  // /**
  // * This method makes the <em>previous</em> and <em>next</em> buttons visible and connects them with the given
  // * <code>handler</code>.
  // *
  // * @param handler is the {@link UiHandlerActionPreviousNext}.
  // */
  // void setPreviousNextHandler(UiHandlerActionPreviousNext handler);

}
