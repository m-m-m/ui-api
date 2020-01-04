/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Implementation of {@link UiWidgetFactoryNative}.
 */
public class UiWidgetFactoryNativeImpl implements UiWidgetFactoryNative {

  /** The singleton instance. */
  public static final UiWidgetFactoryNativeImpl INSTANCE = new UiWidgetFactoryNativeImpl();

  private final Map<Class<? extends UiNativeWidget>, UiSingleWidgetFactoryNative<?>> factoryMap;

  /**
   * The constructor.
   */
  @SuppressWarnings("rawtypes")
  public UiWidgetFactoryNativeImpl() {

    super();
    this.factoryMap = new HashMap<>();
    ServiceLoader<UiSingleWidgetFactoryNative> serviceLoader = ServiceLoader.load(UiSingleWidgetFactoryNative.class);
    for (UiSingleWidgetFactoryNative<?> factory : serviceLoader) {
      registerFactory(factory);
    }
  }

  private void registerFactory(UiSingleWidgetFactoryNative<?> factory) {

    UiSingleWidgetFactoryNative<?> duplicate = this.factoryMap.putIfAbsent(factory.getWidgetInterface(), factory);
    if (duplicate != null) {
      throw new IllegalStateException("Duplicate factory " + factory.getClass().getName() + " and "
          + duplicate.getClass().getName() + " for " + factory.getWidgetInterface().getName());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, UiContext context) {

    UiSingleWidgetFactoryNative<?> factory = this.factoryMap.get(widgetInterface);
    if (factory == null) {
      throw new UnsupportedOperationException(widgetInterface.getName());
    }
    return (W) factory.create(context);
  }

}
