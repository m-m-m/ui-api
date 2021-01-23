/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the API for the universal user-interface framework.
 *
 * @uses io.github.mmm.ui.api.binding.UiActionBinding
 * @uses io.github.mmm.ui.api.factory.UiToggleGroupFactory
 * @uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty
 * @uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype
 * @uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 * @uses io.github.mmm.ui.api.notify.UiNotifier
 * @uses io.github.mmm.ui.api.UiScreen
 * @uses io.github.mmm.ui.api.UiLocalizer
 * @uses io.github.mmm.ui.api.UiContext
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.api.core {

  requires transitive io.github.mmm.event;

  requires transitive io.github.mmm.validation.main;

  requires transitive io.github.mmm.value;

  uses io.github.mmm.ui.api.binding.UiActionBinding;

  uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;

  uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype;

  uses io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty;

  uses io.github.mmm.ui.api.factory.UiToggleGroupFactory;

  uses io.github.mmm.ui.api.notify.UiNotifier;

  uses io.github.mmm.ui.api.UiLocalizer;

  uses io.github.mmm.ui.api.UiScreen;

  exports io.github.mmm.ui.api;

  exports io.github.mmm.ui.api.attribute;

  exports io.github.mmm.ui.api.binding;

  exports io.github.mmm.ui.api.datatype;

  exports io.github.mmm.ui.api.datatype.bitmask;

  exports io.github.mmm.ui.api.datatype.color;

  exports io.github.mmm.ui.api.event;

  exports io.github.mmm.ui.api.event.action;

  exports io.github.mmm.ui.api.factory;

  exports io.github.mmm.ui.api.notify;

  exports io.github.mmm.ui.api.widget;

  exports io.github.mmm.ui.api.widget.button;

  exports io.github.mmm.ui.api.widget.composite;

  exports io.github.mmm.ui.api.widget.img;

  exports io.github.mmm.ui.api.widget.input;

  exports io.github.mmm.ui.api.widget.link;

  exports io.github.mmm.ui.api.widget.panel;

  exports io.github.mmm.ui.api.widget.value;

}
