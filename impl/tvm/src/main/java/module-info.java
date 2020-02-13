import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.factory.TvmFactoryAudioPlayer;
import io.github.mmm.ui.tvm.factory.TvmFactoryButton;
import io.github.mmm.ui.tvm.factory.TvmFactoryCheckbox;
import io.github.mmm.ui.tvm.factory.TvmFactoryFormPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryHorizontalPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryLabel;
import io.github.mmm.ui.tvm.factory.TvmFactoryMediaPlayer;
import io.github.mmm.ui.tvm.factory.TvmFactoryMenu;
import io.github.mmm.ui.tvm.factory.TvmFactoryMenuItem;
import io.github.mmm.ui.tvm.factory.TvmFactoryPasswordInput;
import io.github.mmm.ui.tvm.factory.TvmFactoryRadioButton;
import io.github.mmm.ui.tvm.factory.TvmFactoryTab;
import io.github.mmm.ui.tvm.factory.TvmFactoryTabPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryTextArea;
import io.github.mmm.ui.tvm.factory.TvmFactoryTextInput;
import io.github.mmm.ui.tvm.factory.TvmFactoryVerticalPanel;
import io.github.mmm.ui.tvm.factory.TvmFactoryVideoPlayer;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.tvm {

  requires transitive io.github.mmm.ui;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.value;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.validation;

  requires teavm.jso;

  requires teavm.jso.apis;

  provides UiSingleWidgetFactoryNative with //
      TvmFactoryAudioPlayer, //
      TvmFactoryButton, //
      TvmFactoryCheckbox, //
      TvmFactoryFormPanel, //
      TvmFactoryLabel, //
      TvmFactoryHorizontalPanel, //
      TvmFactoryMediaPlayer, //
      TvmFactoryMenu, //
      TvmFactoryMenuItem, //
      // TvmFactoryMenuItemCheckbox, //
      // TvmFactoryMenuItemRadioButton, //
      // TvmFactoryMenuItemSeparator, //
      TvmFactoryPasswordInput, //
      // TvmFactoryPopup, //
      TvmFactoryRadioButton, //
      TvmFactoryTab, //
      TvmFactoryTabPanel, //
      TvmFactoryTextInput, //
      TvmFactoryTextArea, //
      TvmFactoryVerticalPanel, //
      TvmFactoryVideoPlayer //
  // TvmFactoryWindow
  ;

  exports io.github.mmm.ui.tvm;

}
