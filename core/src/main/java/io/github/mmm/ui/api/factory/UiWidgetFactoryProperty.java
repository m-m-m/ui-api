/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.impl.factory.UiWidgetFactoryPropertyImpl;
import io.github.mmm.value.ReadableValue;

/**
 * Interface for a factory used to {@link #create(ReadableValue, boolean) create} {@link UiInput}s for properties.
 * API-Users should use {@link UiInput#of(ReadableValue)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryProperty {

  /**
   * @param <V> type of the {@link ReadableValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableValue property}.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  default <V> UiInput<V> create(ReadableValue<V> property) {

    return create(property, true);
  }

  /**
   * @param <V> type of the {@link ReadableValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableValue property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty} or
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be registered for the given
   *        {@code property}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  <V> UiInput<V> create(ReadableValue<V> property, boolean required);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryProperty get() {

    return UiWidgetFactoryPropertyImpl.INSTANCE;
  }

}
