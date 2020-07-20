/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

import io.github.mmm.ui.api.widget.button.UiAbstractButton;

/**
 * {@link UiAbstractMenuItem} for a normal menu item.
 * 
 * @since 1.0.0
 */
public abstract interface UiMenuItem extends UiAbstractMenuItem, UiAbstractButton {

  /**
   * The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for this widget in {@link UiNavigationBar}.
   */
  static final String STYLE_NAV = "ui-navitem";
}
