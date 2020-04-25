/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Factory for {@link UiInput} for a single {@link #getType() property}.
 *
 * @param <V> is the generic type of the {@link #getType() property}.
 *
 * @since 1.0.0
 */
public interface UiSingleWidgetFactoryProperty<V> extends UiSingleWidgetFactory<UiInput<V>> {

  /**
   * @return the class reflecting the {@link ReadableTypedValue property}.
   */
  @Override
  Class<? extends ReadableTypedValue<V>> getType();

  /**
   * @see UiWidgetFactoryDatatype#create(Class, boolean)
   * @see UiInput#of(ReadableTypedValue)
   */
  @Override
  UiInput<V> create();

}
