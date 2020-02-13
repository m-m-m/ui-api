/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.media.TvmVideoPlayer;
import io.github.mmm.ui.widget.media.UiVideoPlayer;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiVideoPlayer}.
 *
 * @since 1.0.0
 */
public class TvmFactoryVideoPlayer implements UiSingleWidgetFactoryNative<UiVideoPlayer> {

  @Override
  public Class<UiVideoPlayer> getType() {

    return UiVideoPlayer.class;
  }

  @Override
  public UiVideoPlayer create(UiContext context) {

    return new TvmVideoPlayer(context);
  }

}
