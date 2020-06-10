/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.action.UiAction;

/**
 * {@link UiAbstractMenu} that can also have {@link UiMenuItem}s and {@link UiMenuItemSeparator}s as
 * {@link #getChild(int) children}.
 *
 * @see #addItem(String, UiClickEventListener, int)
 * @see #addSeparator(int)
 * @since 1.0.0
 */
public interface UiAbstractMenuWithItems extends UiAbstractMenu<UiAbstractMenuEntry> {

  /**
   * @param text the new {@link UiMenuItem#getText() label text} of the {@link UiMenuItem} to create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @return the created and added {@link UiMenuItem}.
   */
  default UiMenuItem addItem(String text, UiClickEventListener listener) {

    return addItem(text, listener, -1);
  }

  /**
   * @param text the new {@link UiMenuItem#getText() label text} of the {@link UiMenuItem} to create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new {@link UiMenuItem}.
   * @return the created and added {@link UiMenuItem}.
   */
  UiMenuItem addItem(String text, UiClickEventListener listener, int index);

  /**
   * @param action the {@link UiAction} to bind.
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new {@link UiMenuItem}.
   * @return the created and added {@link UiMenuItem}.
   */
  default UiMenuItem addItem(UiAction action) {

    return addItem(action, -1);
  }

  /**
   * @param action the {@link UiAction} to bind.
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new {@link UiMenuItem}.
   * @return the created and added {@link UiMenuItem}.
   */
  default UiMenuItem addItem(UiAction action, int index) {

    UiMenuItem item = addItem(null, null, index);
    UiActionBinding.get().bind(action, item);
    return item;
  }

  /**
   * @return the {@link UiMenuItemSeparator} that has been created and added to this menu.
   */
  default UiMenuItemSeparator addSeparator() {

    return addSeparator(-1);
  }

  /**
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new
   *        {@link UiMenuItemSeparator}.
   * @return the {@link UiMenuItemSeparator} that has been created and added to this menu.
   */
  UiMenuItemSeparator addSeparator(int index);

}
