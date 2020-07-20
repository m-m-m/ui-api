/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

import io.github.mmm.ui.api.attribute.AttributeWriteText;

/**
 * {@link UiAbstractMenuEntry Navigation entry} that represents a group of other {@link UiAbstractMenuEntry navigation
 * entries}. If created via a {@link UiMenuBar} this will be a menu that can be opened and if created from a
 * {@link UiNavigationBar} it will be a link that collapses or expands its {@link #getChild(int) children}.
 */
public interface UiMenu extends UiAbstractMenuEntry, UiAbstractMenuWithItems, AttributeWriteText {

  /**
   * The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for this widget in {@link UiNavigationBar}.
   */
  static final String STYLE_NAV = "ui-navmenu";

}
