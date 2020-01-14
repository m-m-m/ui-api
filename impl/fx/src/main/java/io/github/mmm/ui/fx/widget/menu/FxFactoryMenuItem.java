/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.menu.UiMenuItem;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItem}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItem implements UiSingleWidgetFactoryNative<UiMenuItem> {

  @Override
  public Class<UiMenuItem> getWidgetInterface() {

    return UiMenuItem.class;
  }

  @Override
  public UiMenuItem create(UiContext context) {

    return new FxMenuItem(context);
  }

}
