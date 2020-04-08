/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.impl.UiWidgetFactoryNativeImpl;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * Interface for a factory used to {@link #create(Class, boolean, UiContext) create} {@link UiNativeWidget native
 * widgets}. API-Users should typically use {@link io.github.mmm.ui.api.UiContext#create(Class)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryNative {

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @param context the {@link UiContext}.
   * @return the new {@link UiNativeWidget}.
   * @see UiContext#create(Class)
   * @see UiSingleWidgetFactoryNative#create(UiContext)
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required, UiContext context);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryNative get() {

    return UiWidgetFactoryNativeImpl.INSTANCE;
  }

}