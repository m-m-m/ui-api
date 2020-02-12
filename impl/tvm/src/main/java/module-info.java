import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.TvmFactoryLabel;
import io.github.mmm.ui.tvm.widget.button.TvmFactoryButton;
import io.github.mmm.ui.tvm.widget.composite.TvmFactoryTab;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryCheckbox;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryPasswordInput;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryRadioButton;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextArea;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextInput;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryAudioPlayer;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryMediaPlayer;
import io.github.mmm.ui.tvm.widget.media.TvmFactoryVideoPlayer;
import io.github.mmm.ui.tvm.widget.menu.TvmFactoryMenu;
import io.github.mmm.ui.tvm.widget.menu.TvmFactoryMenuItem;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryFormPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryHorizontalPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryTabPanel;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryVerticalPanel;

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
