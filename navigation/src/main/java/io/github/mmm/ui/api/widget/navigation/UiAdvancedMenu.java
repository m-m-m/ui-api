/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

import io.github.mmm.ui.api.event.UiClickEventListener;

/**
 * {@link UiMenu} with advanced features such as support for {@link UiMenuItemCheckbox} and
 * {@link UiMenuItemRadioButton}.
 *
 * @since 1.0.0
 */
public interface UiAdvancedMenu extends UiMenu {

  @Override
  default UiAdvancedMenu addMenu(String text) {

    return addMenu(text, -1);
  }

  @Override
  UiAdvancedMenu addMenu(String text, int index);

  /**
   * @param text the new {@link UiMenuItemCheckbox#getText() label text} of the {@link UiMenuItemCheckbox} to create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @return the created and added {@link UiMenuItemCheckbox}.
   */
  default UiMenuItemCheckbox addCheckbox(String text, UiClickEventListener listener) {

    return addCheckbox(text, listener, -1);
  }

  /**
   * @param text the new {@link UiMenuItemCheckbox#getText() label text} of the {@link UiMenuItemCheckbox} to create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new
   *        {@link UiMenuItemCheckbox}.
   * @return the created and added {@link UiMenuItemCheckbox}.
   */
  UiMenuItemCheckbox addCheckbox(String text, UiClickEventListener listener, int index);

  /**
   * @param text the new {@link UiMenuItemRadioButton#getText() label text} of the {@link UiMenuItemRadioButton} to
   *        create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @return the created and added {@link UiMenuItemRadioButton}.
   */
  default UiMenuItemRadioButton addRadioButton(String text, UiClickEventListener listener) {

    return addRadioButton(text, listener, -1);
  }

  /**
   * @param text the new {@link UiMenuItemRadioButton#getText() label text} of the {@link UiMenuItemRadioButton} to
   *        create.
   * @param listener the {@link UiClickEventListener} to listen for {@link io.github.mmm.ui.api.event.UiClickEvent}s.
   * @param index is the {@link #getChildIndex(UiAbstractMenuEntry) index} where to insert the new
   *        {@link UiMenuItemRadioButton}.
   * @return the created and added {@link UiMenuItemRadioButton}.
   */
  UiMenuItemRadioButton addRadioButton(String text, UiClickEventListener listener, int index);

}
