import io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryProperty;

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

  requires transitive io.github.mmm.validation.main;

  requires transitive io.github.mmm.value;

  exports io.github.mmm.ui;

  exports io.github.mmm.ui.attribute;

  exports io.github.mmm.ui.binding;

  exports io.github.mmm.ui.datatype;

  exports io.github.mmm.ui.datatype.bitmask;

  exports io.github.mmm.ui.datatype.chart;

  exports io.github.mmm.ui.datatype.color;

  exports io.github.mmm.ui.datatype.media;

  exports io.github.mmm.ui.event;

  exports io.github.mmm.ui.event.action;

  exports io.github.mmm.ui.factory;

  exports io.github.mmm.ui.spi;

  exports io.github.mmm.ui.spi.factory;

  exports io.github.mmm.ui.spi.range;

  exports io.github.mmm.ui.spi.widget;

  exports io.github.mmm.ui.spi.window;

  exports io.github.mmm.ui.widget;

  exports io.github.mmm.ui.widget.attribute;

  exports io.github.mmm.ui.widget.button;

  exports io.github.mmm.ui.widget.chart;

  exports io.github.mmm.ui.widget.composite;

  exports io.github.mmm.ui.widget.custom;

  exports io.github.mmm.ui.widget.img;

  exports io.github.mmm.ui.widget.input;

  exports io.github.mmm.ui.widget.media;

  exports io.github.mmm.ui.widget.menu;

  exports io.github.mmm.ui.widget.panel;

  exports io.github.mmm.ui.widget.value;

  exports io.github.mmm.ui.widget.window;

  uses UiSingleWidgetFactoryNative;

  uses UiSingleWidgetFactoryDatatype;

  uses UiSingleWidgetFactoryProperty;

  provides UiSingleWidgetFactoryDatatype with //
      io.github.mmm.ui.factory.datatype.UiFactoryDatatypeInteger, //
      io.github.mmm.ui.factory.datatype.UiFactoryDatatypeBoolean, //
      io.github.mmm.ui.factory.datatype.UiFactoryDatatypeString;
}
