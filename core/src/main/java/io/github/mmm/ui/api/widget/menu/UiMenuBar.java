/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} representing a <em>menu bar</em>. It is {@link #getChild(int) contains} {@link UiMenu}s
 * that are displayed by their title in the menu bar. <br>
 * <b>ATTENTION:</b><br>
 * A {@link UiMenuBar} should only be accessed via {@link io.github.mmm.ui.api.widget.window.UiMainWindow#getMenuBar()}.
 * Never manually create {@link UiMenuBar} via {@link io.github.mmm.ui.api.UiContext#create(Class)}. This is only possible
 * for modularity of the UI implementations and direct creation outside {@link io.github.mmm.ui.api.UiContext} is
 * unspecified and behavior can change in future versions.
 *
 * @since 1.0.0
 */
public interface UiMenuBar extends UiDynamicComposite<UiMenu>, UiNativeWidget {

  /**
   * This method {@link #addChild(UiMenu) adds} a {@link UiMenu menu} to this menu-bar.
   *
   * @param label is the {@link UiMenu#getText() label} of the menu.
   * @return the new menu.
   */
  default UiMenu addMenu(String label) {

    UiMenu menu = getContext().create(UiMenu.class);
    menu.setText(label);
    addChild(menu);
    return menu;
  }

}
