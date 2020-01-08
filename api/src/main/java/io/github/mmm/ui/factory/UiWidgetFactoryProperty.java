/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.impl.UiWidgetFactoryPropertyImpl;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Interface for a factory used to {@link #create(Class, boolean, UiContext) create} {@link UiInput}. API-Users should
 * typically use {@link io.github.mmm.ui.UiContext#createInput(ReadableTypedValue, boolean)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryProperty {

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getDatatype() datatype}.
   * @param property is the {@link Class} reflecting the {@link UiSingleWidgetFactoryProperty#getProperty() property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @param context the {@link UiContext}.
   * @return the new {@link UiInput}.
   * @see UiContext#createInput(ReadableTypedValue, boolean)
   * @see UiSingleWidgetFactoryProperty#create(UiContext)
   */
  <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> property, boolean required, UiContext context);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryProperty get() {

    return UiWidgetFactoryPropertyImpl.INSTANCE;
  }

}
