/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxDynamicComposite;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 * Implementation of {@link UiMenuBar} using JavaFx {@link MenuBar}.
 *
 * @since 1.0.0
 */
public class FxMenuBar extends FxDynamicComposite<MenuBar, UiMenu> implements UiMenuBar {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMenuBar(UiContext context) {

    super(context, new MenuBar());
  }

  private Menu getMenu(UiMenu menu) {

    return ((FxMenu) menu).getWidget();
  }

  @Override
  protected void addChildWidget(UiMenu child, int index) {

    if (index == -1) {
      this.widget.getMenus().add(getMenu(child));
    } else {
      this.widget.getMenus().add(index, getMenu(child));
    }
  }

  @Override
  protected void removeChildWidget(UiMenu child, int index) {

    this.widget.getMenus().remove(index);
  }

}
