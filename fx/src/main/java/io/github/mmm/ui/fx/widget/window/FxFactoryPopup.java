/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.window.UiPopup;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiPopup}.
 *
 * @since 1.0.0
 */
public class FxFactoryPopup implements UiSingleWidgetFactoryNative<UiPopup> {

  @Override
  public Class<UiPopup> getWidgetInterface() {

    return UiPopup.class;
  }

  @Override
  public UiPopup create(UiContext context) {

    return new FxPopup(context);
  }

}
