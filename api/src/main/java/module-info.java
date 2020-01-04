import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the API for the universal user-interface framework.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui {

  requires transitive io.github.mmm.event;

  requires transitive io.github.mmm.validation;

  exports io.github.mmm.ui;

  exports io.github.mmm.ui.datatype;

  exports io.github.mmm.ui.event;

  exports io.github.mmm.ui.factory;

  exports io.github.mmm.ui.spi;

  exports io.github.mmm.ui.spi.widget;

  exports io.github.mmm.ui.widget;

  exports io.github.mmm.ui.widget.button;

  exports io.github.mmm.ui.widget.composite;

  exports io.github.mmm.ui.widget.custom;

  exports io.github.mmm.ui.widget.input;

  exports io.github.mmm.ui.widget.menu;

  exports io.github.mmm.ui.widget.panel;

  exports io.github.mmm.ui.widget.value;

  exports io.github.mmm.ui.widget.window;

  uses UiSingleWidgetFactoryNative;
}
