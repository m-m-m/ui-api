/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
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

    Class<?> type = factory.getType();
    if (type == null) {
      registerFactoryWithoutType(factory);
    } else {
      F existing = this.factoryMap.putIfAbsent(type, factory);
      if (existing != null) {
        F mergedFactory = merge(existing, factory);
        if (mergedFactory == null) {
          throw new DuplicateObjectException(factory, UiSingleWidgetFactory.class.getSimpleName(), existing);
        } else if (mergedFactory != existing) {
          this.factoryMap.put(type, mergedFactory);
        }
      }
    }
  }

  /**
   * @param existingFactory the existing {@link UiSingleWidgetFactory} to merge.
   * @param newFactory the new {@link UiSingleWidgetFactory} to merge.
   * @return the merged {@link UiSingleWidgetFactory} or {@code null} if not able to merge and a
   *         {@link DuplicateObjectException} shall be thrown.
   */
  protected F merge(F existingFactory, F newFactory) {

    return null;
  }

  /**
   * @param factory the {@link UiSingleWidgetFactory} without a {@link UiSingleWidgetFactory#getType() type} to
   *        register.
   */
  protected void registerFactoryWithoutType(F factory) {

    throw new IllegalStateException("Illegal factory without type: " + factory.getClass().getName());
  }

  /**
   * @param type the {@link UiSingleWidgetFactory#getType() type} of the according {@link UiSingleWidgetFactory}.
   * @return the {@link UiSingleWidgetFactory} {@link UiSingleWidgetFactory#getType() of} the given {@code type} or
   *         {@code null} if no such factory is registered.
   */
  protected F getForType(Class<?> type) {

    return this.factoryMap.get(type);
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
      throw new ObjectNotFoundException(UiSingleWidgetFactory.class.getSimpleName(), type.getName());
    }
    return (W) factory.create();
  }

}
