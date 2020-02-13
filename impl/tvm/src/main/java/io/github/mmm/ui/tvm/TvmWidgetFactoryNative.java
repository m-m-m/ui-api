/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.spi.factory.AbstractUiWidgetFactory;
import io.github.mmm.ui.tvm.factory.TvmFactoryAudioPlayer;
import io.github.mmm.ui.tvm.factory.TvmFactoryButton;
import io.github.mmm.ui.tvm.factory.TvmFactoryFormPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryHorizontalPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryLabel;
import io.github.mmm.ui.tvm.factory.TvmFactoryMediaPlayer;
import io.github.mmm.ui.tvm.factory.TvmFactoryPasswordInput;
import io.github.mmm.ui.tvm.factory.TvmFactoryRadioButton;
import io.github.mmm.ui.tvm.factory.TvmFactoryRadioChoice;
import io.github.mmm.ui.tvm.factory.TvmFactoryTab;
import io.github.mmm.ui.tvm.factory.TvmFactoryTabPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryTextArea;
import io.github.mmm.ui.tvm.factory.TvmFactoryTextInput;
import io.github.mmm.ui.tvm.factory.TvmFactoryVerticalPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryVideoPlayer;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Implementation of {@link UiWidgetFactoryNative} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmWidgetFactoryNative extends AbstractUiWidgetFactory<UiSingleWidgetFactoryNative<?>>
    implements UiWidgetFactoryNative {

  /**
   * The constructor.
   */
  public TvmWidgetFactoryNative() {

    super(null);
    registerFactory(new TvmFactoryAudioPlayer());
    registerFactory(new TvmFactoryButton());
    registerFactory(new TvmFactoryFormPanel());
    registerFactory(new TvmFactoryHorizontalPanel());
    registerFactory(new TvmFactoryLabel());
    registerFactory(new TvmFactoryMediaPlayer());
    registerFactory(new TvmFactoryPasswordInput());
    registerFactory(new TvmFactoryRadioButton());
    registerFactory(new TvmFactoryRadioChoice());
    registerFactory(new TvmFactoryTab());
    registerFactory(new TvmFactoryTabPanel());
    registerFactory(new TvmFactoryTextArea());
    registerFactory(new TvmFactoryTextInput());
    registerFactory(new TvmFactoryVideoPlayer());
    registerFactory(new TvmFactoryVerticalPanel());
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required, UiContext context) {

    return createForType(widgetInterface, required, context);
  }

}
