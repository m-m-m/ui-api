/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.widget.value.UiAbstractRadioButton;

/**
 * {@link UiAbstractMenuItem} that additionally has a {@link UiAbstractRadioButton radio button}. <br>
 * All {@link UiMenuItemRadioButton radio menu items} within the same {@link UiMenu menu} will automatically belong to
 * the same group (so only one of them can be selected at a time).
 *
 * @since 1.0.0
 */
public interface UiMenuItemRadioButton extends UiAbstractMenuItem, UiAbstractRadioButton {

  // nothing to add

}
