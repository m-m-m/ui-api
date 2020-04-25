/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.impl.factory.UiWidgetFactoryPropertyImpl;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Interface for a factory used to {@link #create(Class, boolean) create} {@link UiInput}. API-Users should use
 * {@link UiInput#of(ReadableTypedValue)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryProperty {

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param propertyType is the {@link Class} reflecting the {@link UiSingleWidgetFactoryProperty#getType() property}.
   * @return the new {@link UiInput}.
   * @see UiSingleWidgetFactoryProperty#create()
   */
  default <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> propertyType) {

    return create(propertyType, true);
  }

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param propertyType is the {@link Class} reflecting the {@link UiSingleWidgetFactoryProperty#getType() property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @return the new {@link UiInput}.
   * @see UiSingleWidgetFactoryProperty#create()
   */
  <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> propertyType, boolean required);

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  default <V> UiInput<V> create(ReadableTypedValue<V> property) {

    return create(property, true);
  }

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty} or
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be registered for the given
   *        {@code property}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  @SuppressWarnings("unchecked")
  default <V> UiInput<V> create(ReadableTypedValue<V> property, boolean required) {

    Class<? extends ReadableTypedValue<V>> propertyType = (Class<? extends ReadableTypedValue<V>>) property.getClass();
    UiInput<V> input = create(propertyType, false);
    if (input == null) {
      input = UiWidgetFactoryDatatype.get().create(property.getValueClass(), required);
    }
    return input;
  }

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryProperty get() {

    return UiWidgetFactoryPropertyImpl.INSTANCE;
  }

}
