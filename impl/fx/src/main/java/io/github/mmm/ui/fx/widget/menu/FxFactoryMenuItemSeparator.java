/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.menu.UiMenuItemSeparator;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItemSeparator}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItemSeparator implements UiSingleWidgetFactoryNative<UiMenuItemSeparator> {

  @Override
  public Class<UiMenuItemSeparator> getType() {

    return UiMenuItemSeparator.class;
  }

  @Override
  public UiMenuItemSeparator create(UiContext context) {

    return new FxMenuItemSeparator(context);
  }

}
