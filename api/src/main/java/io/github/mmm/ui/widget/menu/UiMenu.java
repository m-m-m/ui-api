/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.menu;

import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithText;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} representing a <em>menu</em>. A menu is something that is displayed by its
 * {@link #getText() label} and opens a list of {@link UiAbstractMenuItem menu items} if it is clicked. The user can
 * click on one of these {@link UiAbstractMenuItem menu items} to execute a specific functionality. <br>
 * A {@link UiMenu} is also a {@link UiAbstractMenuItem} so you can add it to another menu as a <em>sub menu</em>.
 *
 * @since 1.0.0
 */
public interface UiMenu
    extends UiDynamicComposite<UiAbstractMenuItem>, UiAbstractMenuItem, UiWidgetWithText, UiNativeWidget {

  /**
   * @param label the {@link UiMenuItem#getText() label} of the {@link UiMenuItem} to create.
   * @param listener the {@link UiEventListener} to listen for {@link UiEvent}s such as
   *        {@link io.github.mmm.ui.event.UiClickEvent}.
   * @return the created and added {@link UiMenuItem}.
   */
  default UiMenuItem addMenuItem(String label, UiEventListener listener) {

    UiMenuItem menuItem = getContext().create(UiMenuItem.class);
    menuItem.setText(label);
    menuItem.addListener(listener);
    addChild(menuItem);
    return menuItem;
  }

  /**
   * This method {@link #addChild(UiAbstractMenuItem) adds} a {@link UiMenuItemSeparator separator} to this menu.
   */
  default void addSeparator() {

    UiMenuItemSeparator separator = getContext().create(UiMenuItemSeparator.class);
    addChild(separator);
  }

  /**
   * @param label is the {@link #getText() label} of the sub-menu.
   * @return the new sub-menu.
   */
  default UiMenu addSubmenu(String label) {

    UiMenu submenu = getContext().create(UiMenu.class);
    submenu.setText(label);
    addChild(submenu);
    return submenu;
  }

}
