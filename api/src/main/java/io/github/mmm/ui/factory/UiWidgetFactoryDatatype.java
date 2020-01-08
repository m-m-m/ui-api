/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.impl.UiWidgetFactoryDatatypeImpl;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Interface for a factory used to {@link #create(Class, boolean, UiContext) create} {@link UiNativeWidget native
 * widgets}. API-Users should typically use {@link io.github.mmm.ui.UiContext#createInput(Class)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryDatatype {

  /**
   * @param <V> type of the {@link UiSingleWidgetFactoryDatatype#getDatatype() datatype}.
   * @param datatype is the {@link Class} reflecting the {@link UiSingleWidgetFactoryDatatype#getDatatype() datatype}.
   * @param required {@code true} if a {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @param context the {@link UiContext}.
   * @return the new {@link UiInput}.
   * @see UiContext#createInput(Class, boolean)
   * @see UiSingleWidgetFactoryDatatype#create(UiContext)
   */
  <V> UiInput<V> create(Class<V> datatype, boolean required, UiContext context);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryDatatype get() {

    return UiWidgetFactoryDatatypeImpl.INSTANCE;
  }

}
