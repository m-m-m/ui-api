import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.button.TvmFactoryButton;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryCheckbox;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextInput;
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

  requires teavm.jso;

  requires teavm.jso.apis;

  provides UiSingleWidgetFactoryNative with //
      TvmFactoryButton, //
      TvmFactoryCheckbox, //
      // TvmFactoryFormPanel, //
      // TvmFactoryLabel, //
      // TvmFactoryHorizontalPanel, //
      // TvmFactoryMenu, //
      // TvmFactoryMenuItem, //
      // TvmFactoryMenuItemCheckbox, //
      // TvmFactoryMenuItemRadioButton, //
      // TvmFactoryMenuItemSeparator, //
      // TvmFactoryPasswordInput, //
      // TvmFactoryPopup, //
      // TvmFactoryTab, //
      // TvmFactoryTabPanel, //
      TvmFactoryTextInput, //
      // TvmFactoryTextArea, //
      TvmFactoryVerticalPanel //
  // TvmFactoryWindow
  ;

  exports io.github.mmm.ui.tvm;

}
