/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * Abstract base implementation for widget factor based on {@link UiSingleWidgetFactory}.
 *
 * @param <F> type of the {@link UiSingleWidgetFactory} to compose.
 * @since 1.0.0
 */
public class AbstractUiWidgetFactory<F extends UiSingleWidgetFactory<?>> {

  private final Map<Class<?>, F> factoryMap;

  /**
   * The constructor.
   *
   * @param singleFactoryClass the {@link Class} reflecing the concrete {@link UiSingleWidgetFactory} sub-interface.
   */
  public AbstractUiWidgetFactory(Class<F> singleFactoryClass) {

    super();
    this.factoryMap = new HashMap<>();
    if (singleFactoryClass != null) {
      ServiceLoader<F> serviceLoader = ServiceLoader.load(singleFactoryClass);
      for (F factory : serviceLoader) {
        registerFactory(factory);
      }
    }
  }

  /**
   * @param factory the {@link UiSingleWidgetFactory} to register.
   */
  protected void registerFactory(F factory) {

    F duplicate = this.factoryMap.putIfAbsent(factory.getType(), factory);
    if (duplicate != null) {
      throw new IllegalStateException("Duplicate factory " + factory.getClass().getName() + " and "
          + duplicate.getClass().getName() + " for " + factory.getType().getName());
    }
  }

  /**
   * @param <W> type of the {@link UiWidget} to create.
   * @param type the {@link UiSingleWidgetFactory#getType() type} of the according {@link UiSingleWidgetFactory}.
   * @param required - {@code true} if the result is required, {@code false} otherwise.
   * @return the created {@link UiWidget} or {@code null} if {@code required} is {@code false} and no
   *         {@link UiSingleWidgetFactory} is {@link #registerFactory(UiSingleWidgetFactory) registered} for the the
   *         given type.
   */
  @SuppressWarnings("unchecked")
  protected <W extends UiWidget> W createForType(Class<?> type, boolean required) {

    F factory = this.factoryMap.get(type);
    if (factory == null) {
      if (!required) {
        return null;
      }
      System.out.println("No Factory registered for " + type.getName());
      // throw new ObjectNotFoundException("WidgetFactory", type.getName());
      throw new IllegalArgumentException(type.getName());
    }
    return (W) factory.create();
  }

}
