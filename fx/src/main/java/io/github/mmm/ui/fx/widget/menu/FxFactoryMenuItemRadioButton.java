/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.menu.UiMenuItemRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItemRadioButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItemRadioButton implements UiSingleWidgetFactoryNative<UiMenuItemRadioButton> {

  @Override
  public Class<UiMenuItemRadioButton> getWidgetInterface() {

    return UiMenuItemRadioButton.class;
  }

  @Override
  public UiMenuItemRadioButton create(UiContext context) {

    return new FxMenuItemRadioButton(context);
  }

}
