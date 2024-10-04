/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.value.ReadableValue;

/**
 * Factory for {@link UiInput} for a single {@link #getType() property}.
 *
 * @param <V> the {@link #getType() value type}.
 * @since 1.0.0
 */
public interface UiSingleWidgetFactoryProperty<V> extends UiSingleWidgetFactory<UiInput<V>> {

  /**
   * @return the class reflecting the {@link ReadableValue property}. May be {@code null} if a custom
   *         {@link #isResponsible(ReadableValue) responsibility check} is implemented.
   */
  @Override
  Class<? extends ReadableValue<V>> getType();

  /**
   * Override this method for a special factory on a given property {@link #getType() type}.
   *
   * @param property the {@link ReadableValue property} to check. May be {@code null} to check for the default factory
   *        of a given property {@link #getType() type}.
   * @return {@code true} if this factory is responsible for {@link #create() creating} {@link UiInput} widgets for the
   *         given {@code property} in advance to another factory for the same property {@link #getType() type},
   *         {@code false} otherwise.
   */
  default boolean isResponsible(ReadableValue<V> property) {

    return (property == null);
  }

  /**
   * @param property the {@link ReadableValue property} to create the {@link UiInput} widget for.
   * @return the new {@link UiInput}.
   */
  default UiInput<V> create(ReadableValue<V> property) {

    return create();
  }

  /**
   * @see UiWidgetFactoryDatatype#create(Class, boolean)
   * @see UiInput#of(ReadableValue)
   */
  @Override
  UiInput<V> create();

}
