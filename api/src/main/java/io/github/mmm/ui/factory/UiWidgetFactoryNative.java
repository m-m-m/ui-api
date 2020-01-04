/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.impl.UiWidgetFactoryNativeImpl;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Interface for a factory used to {@link #create(Class, UiContext) create} {@link UiNativeWidget native widgets}.
 * API-Users should typically use {@link io.github.mmm.ui.UiContext#create(Class)} instead.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetFactoryNative {

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @param context the {@link UiContext}.
   * @return the new {@link UiNativeWidget}.
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface, UiContext context);

  /**
   * @return the instance of this interface.
   */
  static UiWidgetFactoryNative get() {

    return UiWidgetFactoryNativeImpl.INSTANCE;
  }

}
