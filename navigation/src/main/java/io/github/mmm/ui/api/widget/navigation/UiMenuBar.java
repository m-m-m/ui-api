/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.impl.widget.navigation.UiMenuBarProvider;

/**
 * {@link UiAbstractMenuBar} representing a regular <em>menu bar</em>. It is {@link #getChild(int) contains}
 * {@link UiMenu}s that are displayed by their title in the menu bar. <br>
 * <b>ATTENTION:</b><br>
 * A {@link UiMenuBar} only exists once per application in the {@code main window} and should only be accessed via
 * {@link #get()}. Never manually create {@link UiMenuBar} via
 * {@link io.github.mmm.ui.api.factory.UiWidgetFactoryNative#create(Class)}. This is only possible for modularity of the
 * UI implementations. Direct creation outside this framework is unspecified and behavior can change in future versions.
 *
 * @since 1.0.0
 */
public interface UiMenuBar extends UiAbstractMenuBar<UiAdvancedMenu>, UiNativeWidget {

  @Override
  default UiAdvancedMenu addMenu(String text) {

    return addMenu(text, -1);
  }

  @Override
  UiAdvancedMenu addMenu(String text, int index);

  /**
   * @return the {@link UiMenuBar} of the main window.
   */
  static UiMenuBar get() {

    return UiMenuBarProvider.MENU_BAR;
  }

}
