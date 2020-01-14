/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxComposite;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 * Implementation of {@link UiMenuBar} using JavaFx {@link MenuBar}.
 *
 * @since 1.0.0
 */
public class FxMenuBar extends FxComposite<MenuBar, UiMenu> implements UiMenuBar {

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
  public void addChild(UiMenu child, int index) {

    this.widget.getMenus().add(getMenu(child));
    this.children.add(index, child);
  }

  @Override
  public boolean removeChild(UiMenu child) {

    boolean removed = this.widget.getMenus().remove(getMenu(child));
    if (removed) {
      this.children.remove(child);
    }
    return removed;
  }

  @Override
  public UiMenu removeChild(int index) {

    this.widget.getMenus().remove(index);
    return this.children.remove(index);
  }

}
