/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Abstract base implementation of {@link UiContext}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiContext implements UiContext {

  private UiWidgetFactoryNative factory;

  /**
   * The constructor.
   */
  public AbstractUiContext() {

    super();
    this.factory = UiWidgetFactoryNative.get();
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface) {

    return this.factory.create(widgetInterface, this);
  }

}
