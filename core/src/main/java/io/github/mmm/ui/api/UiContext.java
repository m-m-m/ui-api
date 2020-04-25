/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * Context and central API of the user-interface (UI). UIs consist of many smaller components that should be easy to
 * create. Dependency injection (DI) would make the programming model more complex. In such cases you need to pass
 * required components manually. This context is the central container to make this easy and maintainable. It acts as
 * factory for other {@link UiWidget}s as well as contextual state for the UI.
 *
 * @since 1.0.0
 */
public interface UiContext {

  /**
   * @return the {@link UiDispatcher}.
   */
  UiDispatcher getDispatcher();

  /**
   * @return a new {@link UiToggleGroup} instance.
   */
  UiToggleGroup createToggleGroup();

  /**
   * @return a new instance of {@link UiValidState}.
   */
  default UiValidState newValidState() {

    return new UiValidState();
  }

}