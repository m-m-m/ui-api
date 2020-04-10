/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;
import io.github.mmm.ui.impl.widget.menu.UiMenuBarProvider;

/**
 * {@link UiMutableComposite} representing a <em>menu bar</em>. It is {@link #getChild(int) contains} {@link UiMenu}s
 * that are displayed by their title in the menu bar. <br>
 * <b>ATTENTION:</b><br>
 * A {@link UiMenuBar} should only be accessed via {@link #get()}. Never manually create {@link UiMenuBar} via
 * {@link io.github.mmm.ui.api.UiContext#create(Class)}. This is only possible for modularity of the UI implementations
 * and direct creation outside {@link io.github.mmm.ui.api.UiContext} is unspecified and behavior can change in future
 * versions.
 *
 * @since 1.0.0
 */
public interface UiMenuBar extends UiMutableComposite<UiMenu>, UiNativeWidget {

  /**
   * This method {@link #addChild(UiMenu) adds} a {@link UiMenu menu} to this menu-bar.
   *
   * @param text is the {@link UiMenu#getText() label text} of the {@link UiMenu} to create.
   * @return the new menu.
   */
  default UiMenu addMenu(String text) {

    UiMenu menu = UiMenu.of(text);
    addChild(menu);
    return menu;
  }

  /**
   * @return the {@link UiMenuBar} of the main window.
   */
  static UiMenuBar get() {

    return UiMenuBarProvider.MENU_BAR;
  }

}
