/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractMenuBar} that represents a vertical navigation bar. An example may look like this:<br>
 * <ul>
 * <li><a href="">menuitem 1</a>
 * <li><a href="" onclick="var ul=document.getElementById('group1');if (ul.style.display === 'none')
 * {ul.style.display='block';} else {ul.style.display = 'none';}">menu 1</li>
 * <ul id="group1">
 * <li><a href="">menuitem 2</a>
 * <li><a href="">menuitem 3</a>
 * </ul>
 * </ul>
 *
 * @since 1.0.0
 */
public interface UiNavigationBar
    extends UiAbstractMenuBar<UiAbstractMenuEntry>, UiAbstractMenuWithItems, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name for this widget. */
  String STYLE = "ui-navbar";

}
