/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * {@link UiMutableComposite} representing a <em>menu</em>. A menu is something that is displayed by its
 * {@link #getText() label} and opens a list of {@link UiAbstractMenuItem menu items} if it is clicked. The user can
 * click on one of these {@link UiAbstractMenuItem menu items} to execute a specific functionality. <br>
 * A {@link UiMenu} is also a {@link UiAbstractMenuItem} so you can add it to another menu as a <em>sub menu</em>.
 *
 * @since 1.0.0
 */
public interface UiMenu
    extends UiMutableComposite<UiAbstractMenuItem>, UiAbstractMenuItem, AttributeWriteText, UiNativeWidget {

  /**
   * @param text the new {@link #getText() label text} of the {@link UiMenuItem} to create.
   * @param listener the {@link UiEventListener} to listen for {@link UiEvent}s such as
   *        {@link io.github.mmm.ui.api.event.UiClickEvent}.
   * @return the created and added {@link UiMenuItem}.
   */
  default UiMenuItem addMenuItem(String text, UiEventListener listener) {

    UiMenuItem menuItem = UiMenuItem.of(text, listener);
    addChild(menuItem);
    return menuItem;
  }

  /**
   * This method {@link #addChild(UiAbstractMenuItem) adds} a {@link UiMenuItemSeparator separator} to this menu.
   */
  default void addSeparator() {

    UiMenuItemSeparator separator = UiMenuItemSeparator.of();
    addChild(separator);
  }

  /**
   * @param text the new {@link #getText() label text} of the {@link UiMenu} to create.
   * @return the new sub-menu.
   */
  default UiMenu addSubmenu(String text) {

    UiMenu submenu = UiMenu.of(text);
    addChild(submenu);
    return submenu;
  }

  /**
   * @param text the new {@link #getText() label text} of the {@link UiMenu} to create.
   * @return the new {@link UiMenu}.
   */
  static UiMenu of(String text) {

    UiMenu widget = UiWidgetFactoryNative.get().create(UiMenu.class);
    if (text != null) {
      widget.setText(text);
    }
    return widget;
  }
}
