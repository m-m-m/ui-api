/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.menu;

import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} representing a <em>menu bar</em>. It is {@link #getChild(int) contains} {@link UiMenu}s
 * that are displayed by their title in the menu bar. <br>
 * <b>ATTENTION:</b><br>
 * A {@link UiMenuBar} should typically be accessed via
 * {@link io.github.mmm.ui.widget.window.UiMainWindow#getMenuBar()}. For portability and usability you should avoid
 * creating it manually via {@link io.github.mmm.ui.UiContext}.
 *
 * @since 1.0.0
 */
public interface UiMenuBar extends UiDynamicComposite<UiMenu> {

  /**
   * This method {@link #addChild(UiMenu) adds} a {@link UiMenu menu} to this menu-bar.
   *
   * @param label is the {@link UiMenu#getLabel() label} of the menu.
   * @return the new menu.
   */
  default UiMenu addMenu(String label) {

    UiMenu menu = getContext().create(UiMenu.class);
    menu.setLabel(label);
    addChild(menu);
    return menu;
  }

}
