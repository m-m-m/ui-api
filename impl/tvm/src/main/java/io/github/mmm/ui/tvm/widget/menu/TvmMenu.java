/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import java.util.ArrayList;
import java.util.List;

import org.teavm.jso.dom.html.HTMLButtonElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiAbstractMenuItem;
import io.github.mmm.ui.widget.menu.UiMenu;

/**
 * Implementation of {@link UiMenu} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMenu extends TvmAbstractButtonMenuItem implements UiMenu {

  private final List<UiAbstractMenuItem> children;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmMenu(UiContext context, HTMLButtonElement widget) {

    super(context, widget);
    this.children = new ArrayList<>();
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMenu(UiContext context) {

    super(context);
    this.children = new ArrayList<>();
  }

  @Override
  public void addChild(UiAbstractMenuItem child, int index) {

    if (index >= 0) {
      insertAt(this.widget, getTopNode(child), index);
      this.children.add(index, child);
    } else {
      this.widget.appendChild(getTopNode(child));
      this.children.add(child);
    }
  }

  @Override
  public UiAbstractMenuItem removeChild(int index) {

    UiAbstractMenuItem childItem = this.children.remove(index);
    this.widget.removeChild(getTopNode(childItem));
    return childItem;
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public UiAbstractMenuItem getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public int getChildIndex(UiAbstractMenuItem child) {

    return this.children.indexOf(child);
  }

}
