/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.factory;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactory;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.value.ReadableValue;

/**
 * Implementation of {@link UiSingleWidgetFactoryProperty} to compose multiple {@link UiSingleWidgetFactoryProperty}s
 * for the same {@link #getType() type}.
 *
 * @param <V> the {@link #getType() value type}.
 * @since 1.0.0
 */
public class UiSingleWidgetFactoryPropertyComposed<V> implements UiSingleWidgetFactoryProperty<V> {

  private final Class<? extends ReadableValue<V>> type;

  private final List<UiSingleWidgetFactoryProperty<V>> customFactories;

  private UiSingleWidgetFactoryProperty<V> defaultFactory;

  /**
   * The constructor.
   *
   * @param factory the initial {@link UiSingleWidgetFactoryProperty}.
   */
  public UiSingleWidgetFactoryPropertyComposed(UiSingleWidgetFactoryProperty<V> factory) {

    super();
    this.customFactories = new ArrayList<>();
    this.type = factory.getType();
    add(factory);
  }

  /**
   * @param factory the {@link UiSingleWidgetFactoryProperty} to add to this composed factory (merge).
   */
  public void add(UiSingleWidgetFactoryProperty<V> factory) {

    if (factory.isResponsible(null)) {
      if (this.defaultFactory == null) {
        this.defaultFactory = factory;
      } else {
        throw new DuplicateObjectException(factory, UiSingleWidgetFactory.class.getSimpleName(), this.defaultFactory);
      }
    } else {
      this.customFactories.add(factory);
    }
  }

  @Override
  public Class<? extends ReadableValue<V>> getType() {

    return this.type;
  }

  @Override
  public UiInput<V> create(ReadableValue<V> property) {

    for (UiSingleWidgetFactoryProperty<V> factory : this.customFactories) {
      if (factory.isResponsible(property)) {
        return factory.create(property);
      }
    }
    if (this.defaultFactory != null) {
      return this.defaultFactory.create(property);
    }
    return null;
  }

  @Override
  public UiInput<V> create() {

    throw new IllegalStateException();
  }

  /**
   * @param <V> the {@link #getType() value type}.
   * @param factory the {@link UiSingleWidgetFactoryProperty} to compose.
   * @return the {@link UiSingleWidgetFactoryPropertyComposed}.
   */
  public static <V> UiSingleWidgetFactoryPropertyComposed<V> of(UiSingleWidgetFactoryProperty<V> factory) {

    if (factory instanceof UiSingleWidgetFactoryPropertyComposed) {
      return (UiSingleWidgetFactoryPropertyComposed<V>) factory;
    } else {
      return new UiSingleWidgetFactoryPropertyComposed<>(factory);
    }
  }

}
