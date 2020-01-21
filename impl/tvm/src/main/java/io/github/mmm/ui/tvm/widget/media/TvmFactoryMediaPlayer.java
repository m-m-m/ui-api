/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.media;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.media.UiMediaPlayer;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMediaPlayer}.
 *
 * @since 1.0.0
 */
public class TvmFactoryMediaPlayer implements UiSingleWidgetFactoryNative<UiMediaPlayer> {

  @Override
  public Class<UiMediaPlayer> getType() {

    return UiMediaPlayer.class;
  }

  @Override
  public UiMediaPlayer create(UiContext context) {

    return new TvmMediaPlayer(context);
  }

}
