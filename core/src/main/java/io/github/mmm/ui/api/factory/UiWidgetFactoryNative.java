/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.impl.factory.UiWidgetFactoryNativeImpl;

/**
 * Interface for a factory used to {@link #create(Class, boolean) create} {@link UiNativeWidget native widgets}.
 * API-Users should use static {@code of} methods of {@link UiNativeWidget}s instead such as e.g.
 * {@link io.github.mmm.ui.api.widget.UiLabel#of(String)}.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryNative {

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @return the new {@link UiNativeWidget}.
   * @see UiSingleWidgetFactoryNative#create()
   */
  default <W extends UiNativeWidget> W create(Class<W> widgetInterface) {

    return create(widgetInterface, true);
  }

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @return the new {@link UiNativeWidget}.
   * @see UiSingleWidgetFactoryNative#create()
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryNative get() {

    return UiWidgetFactoryNativeImpl.INSTANCE;
  }

}
