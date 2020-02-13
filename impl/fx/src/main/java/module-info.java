import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.factory.FxFactoryButton;
import io.github.mmm.ui.fx.factory.FxFactoryCheckbox;
import io.github.mmm.ui.fx.factory.FxFactoryFormPanel;
import io.github.mmm.ui.fx.factory.FxFactoryHorizontalPanel;
import io.github.mmm.ui.fx.factory.FxFactoryLabel;
import io.github.mmm.ui.fx.factory.FxFactoryMenu;
import io.github.mmm.ui.fx.factory.FxFactoryMenuItem;
import io.github.mmm.ui.fx.factory.FxFactoryMenuItemCheckbox;
import io.github.mmm.ui.fx.factory.FxFactoryMenuItemRadioButton;
import io.github.mmm.ui.fx.factory.FxFactoryMenuItemSeparator;
import io.github.mmm.ui.fx.factory.FxFactoryPasswordInput;
import io.github.mmm.ui.fx.factory.FxFactoryPopup;
import io.github.mmm.ui.fx.factory.FxFactoryRadioButton;
import io.github.mmm.ui.fx.factory.FxFactoryRadioChoice;
import io.github.mmm.ui.fx.factory.FxFactoryTab;
import io.github.mmm.ui.fx.factory.FxFactoryTabPanel;
import io.github.mmm.ui.fx.factory.FxFactoryTextArea;
import io.github.mmm.ui.fx.factory.FxFactoryTextInput;
import io.github.mmm.ui.fx.factory.FxFactoryVerticalPanel;
import io.github.mmm.ui.fx.factory.FxFactoryWindow;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx {

  requires transitive io.github.mmm.ui;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.value;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.validation.main;

  requires transitive javafx.controls;

  requires javafx.web;

  provides UiSingleWidgetFactoryNative with //
      FxFactoryButton, //
      FxFactoryCheckbox, //
      FxFactoryFormPanel, //
      FxFactoryLabel, //
      FxFactoryVerticalPanel, //
      FxFactoryMenu, //
      FxFactoryMenuItem, //
      FxFactoryMenuItemCheckbox, //
      FxFactoryMenuItemRadioButton, //
      FxFactoryMenuItemSeparator, //
      FxFactoryPasswordInput, //
      FxFactoryPopup, //
      FxFactoryRadioButton, //
      FxFactoryRadioChoice, //
      FxFactoryTab, //
      FxFactoryTabPanel, //
      FxFactoryTextInput, //
      FxFactoryTextArea, //
      FxFactoryHorizontalPanel, //
      FxFactoryWindow;

  exports io.github.mmm.ui.fx;

}
