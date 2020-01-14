import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.FxFactoryButton;
import io.github.mmm.ui.fx.widget.FxFactoryLabel;
import io.github.mmm.ui.fx.widget.composite.FxFactoryTab;
import io.github.mmm.ui.fx.widget.input.FxFactoryCheckbox;
import io.github.mmm.ui.fx.widget.input.FxFactoryPasswordInput;
import io.github.mmm.ui.fx.widget.input.FxFactoryRadioButton;
import io.github.mmm.ui.fx.widget.input.FxFactoryRadioChoice;
import io.github.mmm.ui.fx.widget.input.FxFactoryTextArea;
import io.github.mmm.ui.fx.widget.input.FxFactoryTextInput;
import io.github.mmm.ui.fx.widget.menu.FxFactoryMenu;
import io.github.mmm.ui.fx.widget.menu.FxFactoryMenuItem;
import io.github.mmm.ui.fx.widget.menu.FxFactoryMenuItemCheckbox;
import io.github.mmm.ui.fx.widget.menu.FxFactoryMenuItemRadioButton;
import io.github.mmm.ui.fx.widget.menu.FxFactoryMenuItemSeparator;
import io.github.mmm.ui.fx.widget.panel.FxFactoryFormPanel;
import io.github.mmm.ui.fx.widget.panel.FxFactoryVerticalPanel;
import io.github.mmm.ui.fx.widget.panel.FxFactoryTabPanel;
import io.github.mmm.ui.fx.widget.panel.FxFactoryHorizontalPanel;
import io.github.mmm.ui.fx.widget.window.FxFactoryPopup;
import io.github.mmm.ui.fx.widget.window.FxFactoryWindow;

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
