/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.spi.factory.AbstractUiWidgetFactory;
import io.github.mmm.ui.tvm.widget.TvmFactoryLabel;
import io.github.mmm.ui.tvm.widget.button.TvmFactoryButton;
import io.github.mmm.ui.tvm.widget.composite.TvmFactoryTab;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryPasswordInput;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryRadioButton;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryRadioChoice;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextArea;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextInput;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryAudioPlayer;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryMediaPlayer;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryVideoPlayer;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryFormPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryHorizontalPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryTabPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryVerticalPanel;
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
