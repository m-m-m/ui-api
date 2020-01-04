/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiAbstractMenuItem;
import io.github.mmm.ui.widget.menu.UiMenu;
import javafx.scene.control.Menu;

/**
 * Implementation of {@link UiMenu} using JavaFx {@link Menu}.
 *
 * @since 1.0.0
 */
public class FxMenu extends FxAbstractMenuItem<Menu> implements UiMenu {

  private final List<FxAbstractMenuItem<?>> children;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMenu(UiContext context) {

    super(context, new Menu());
    this.children = new ArrayList<>();
  }

  @Override
  public boolean removeChild(UiAbstractMenuItem child) {

    boolean removed = this.children.remove(child);
    if (removed) {
      FxAbstractMenuItem<?> childItem = (FxAbstractMenuItem<?>) child;
      this.nativeWidget.getItems().remove(childItem.getNativeWidget());
    }
    return removed;
  }

  @Override
  public UiAbstractMenuItem removeChild(int index) {

    FxAbstractMenuItem<?> childItem = this.children.remove(index);
    this.nativeWidget.getItems().remove(childItem.getNativeWidget());
    return childItem;
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public int getChildIndex(UiAbstractMenuItem child) {

    return this.children.indexOf(child);
  }

  @Override
  public UiAbstractMenuItem getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public void addChild(UiAbstractMenuItem child, int index) {

    FxAbstractMenuItem<?> fxChild = (FxAbstractMenuItem<?>) child;
    this.nativeWidget.getItems().add(fxChild.getNativeWidget());
    this.children.add(index, fxChild);
  }

}
