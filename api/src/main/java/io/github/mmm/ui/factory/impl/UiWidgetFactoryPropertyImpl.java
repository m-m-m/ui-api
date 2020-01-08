/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryProperty;
import io.github.mmm.ui.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Implementation of {@link UiWidgetFactoryProperty}.
 */
public class UiWidgetFactoryPropertyImpl implements UiWidgetFactoryProperty {

  /** The singleton instance. */
  public static final UiWidgetFactoryPropertyImpl INSTANCE = new UiWidgetFactoryPropertyImpl();

  private final Map<Class<? extends ReadableTypedValue<?>>, UiSingleWidgetFactoryProperty<?>> factoryMap;

  /**
   * The constructor.
   */
  @SuppressWarnings("rawtypes")
  public UiWidgetFactoryPropertyImpl() {

    super();
    this.factoryMap = new HashMap<>();
    ServiceLoader<UiSingleWidgetFactoryProperty> serviceLoader = ServiceLoader
        .load(UiSingleWidgetFactoryProperty.class);
    for (UiSingleWidgetFactoryProperty<?> factory : serviceLoader) {
      registerFactory(factory);
    }
  }

  private void registerFactory(UiSingleWidgetFactoryProperty<?> factory) {

    UiSingleWidgetFactoryProperty<?> duplicate = this.factoryMap.putIfAbsent(factory.getProperty(), factory);
    if (duplicate != null) {
      throw new IllegalStateException("Duplicate factory " + factory.getClass().getName() + " and "
          + duplicate.getClass().getName() + " for " + factory.getProperty().getName());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> property, boolean required, UiContext context) {

    UiSingleWidgetFactoryProperty<V> factory = (UiSingleWidgetFactoryProperty<V>) this.factoryMap.get(property);
    if (factory == null) {
      if (!required) {
        return null;
      }
      throw new UnsupportedOperationException(property.getName());
    }
    return factory.create(context);
  }

}
