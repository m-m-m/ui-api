/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.window.FxWindow;
import io.github.mmm.ui.widget.window.UiWindow;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiWindow}.
 *
 * @since 1.0.0
 */
public class FxFactoryWindow implements UiSingleWidgetFactoryNative<UiWindow> {

  @Override
  public Class<UiWindow> getType() {

    return UiWindow.class;
  }

  @Override
  public UiWindow create(UiContext context) {

    return new FxWindow(context);
  }

}
