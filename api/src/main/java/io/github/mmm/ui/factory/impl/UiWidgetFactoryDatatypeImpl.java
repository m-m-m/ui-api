/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype;
import io.github.mmm.ui.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Implementation of {@link UiWidgetFactoryDatatype}.
 */
public class UiWidgetFactoryDatatypeImpl implements UiWidgetFactoryDatatype {

  /** The singleton instance. */
  public static final UiWidgetFactoryDatatypeImpl INSTANCE = new UiWidgetFactoryDatatypeImpl();

  private final Map<Class<?>, UiSingleWidgetFactoryDatatype<?>> factoryMap;

  /**
   * The constructor.
   */
  @SuppressWarnings("rawtypes")
  public UiWidgetFactoryDatatypeImpl() {

    super();
    this.factoryMap = new HashMap<>();
    ServiceLoader<UiSingleWidgetFactoryDatatype> serviceLoader = ServiceLoader
        .load(UiSingleWidgetFactoryDatatype.class);
    for (UiSingleWidgetFactoryDatatype<?> factory : serviceLoader) {
      registerFactory(factory);
    }
  }

  private void registerFactory(UiSingleWidgetFactoryDatatype<?> factory) {

    UiSingleWidgetFactoryDatatype<?> duplicate = this.factoryMap.putIfAbsent(factory.getDatatype(), factory);
    if (duplicate != null) {
      throw new IllegalStateException("Duplicate factory " + factory.getClass().getName() + " and "
          + duplicate.getClass().getName() + " for " + factory.getDatatype().getName());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V> UiInput<V> create(Class<V> datatype, boolean required, UiContext context) {

    UiSingleWidgetFactoryDatatype<V> factory = (UiSingleWidgetFactoryDatatype<V>) this.factoryMap.get(datatype);
    if (factory == null) {
      if (!required) {
        return null;
      }
      throw new UnsupportedOperationException(datatype.getName());
    }
    return factory.create(context);
  }

}
