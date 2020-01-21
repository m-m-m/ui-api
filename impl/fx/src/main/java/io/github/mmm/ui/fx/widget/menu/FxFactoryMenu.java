/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.menu.UiMenu;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenu}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenu implements UiSingleWidgetFactoryNative<UiMenu> {

  @Override
  public Class<UiMenu> getType() {

    return UiMenu.class;
  }

  @Override
  public UiMenu create(UiContext context) {

    return new FxMenu(context);
  }

}
