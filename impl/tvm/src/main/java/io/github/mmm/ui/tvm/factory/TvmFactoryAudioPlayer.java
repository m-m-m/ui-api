/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.media.TvmAudioPlayer;
import io.github.mmm.ui.widget.media.UiAudioPlayer;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiAudioPlayer}.
 *
 * @since 1.0.0
 */
public class TvmFactoryAudioPlayer implements UiSingleWidgetFactoryNative<UiAudioPlayer> {

  @Override
  public Class<UiAudioPlayer> getType() {

    return UiAudioPlayer.class;
  }

  @Override
  public UiAudioPlayer create(UiContext context) {

    return new TvmAudioPlayer(context);
  }

}
