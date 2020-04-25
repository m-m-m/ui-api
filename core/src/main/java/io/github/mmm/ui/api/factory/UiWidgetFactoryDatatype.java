/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.impl.factory.UiWidgetFactoryDatatypeImpl;

/**
 * Interface for a factory used to {@link #create(Class, boolean) create} {@link UiNativeWidget native widgets}.
 * API-Users should use {@link UiInput#of(Class)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryDatatype {

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype is the {@link Class} reflecting the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @return the new {@link UiInput}.
   * @see UiSingleWidgetFactoryDatatype#create()
   */
  default <V> UiInput<V> create(Class<V> datatype) {

    return create(datatype, true);
  }

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype is the {@link Class} reflecting the {@link UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @return the new {@link UiInput}.
   * @see UiSingleWidgetFactoryDatatype#create()
   */
  <V> UiInput<V> create(Class<V> datatype, boolean required);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryDatatype get() {

    return UiWidgetFactoryDatatypeImpl.INSTANCE;
  }

}
