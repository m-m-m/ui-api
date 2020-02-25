/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import java.util.ArrayList;
import java.util.List;

import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.xml.Node;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiAbstractMenuItem;
import io.github.mmm.ui.widget.menu.UiMenu;

/**
 * Implementation of {@link UiMenu} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMenu extends TvmAbstractButtonMenuItem implements UiMenu {

  private final HTMLElement menu;

  private final List<UiAbstractMenuItem> children;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMenu(UiContext context) {

    this(context, newButton());
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmMenu(UiContext context, HTMLButtonElement widget) {

    super(context, widget);
    this.children = new ArrayList<>();
    this.menu = newElement("ui-menu");
  }

  @Override
  protected void onClick(Event event) {

    Node parentNode = this.menu.getParentNode();
    if (parentNode == null) {
      System.out.println("Opening menu");
      this.menu.setAttribute("style", "left:" + this.widget.getAbsoluteLeft() + "px,top:"
          + (this.widget.getAbsoluteTop() + this.widget.getClientHeight()) + "px");
      DOC.getBody().appendChild(this.menu);
    } else {
      System.out.println("Closing menu");
      parentNode.removeChild(this.menu);
    }
    super.onClick(event);
  }

  @Override
  public void addChild(UiAbstractMenuItem child, int index) {

    if (index == -1) {
      this.menu.appendChild(getTopNode(child));
      this.children.add(child);
    } else {
      insertAt(this.menu, getTopNode(child), index);
      this.children.add(index, child);
    }
  }

  @Override
  public UiAbstractMenuItem removeChild(int index) {

    UiAbstractMenuItem childItem = this.children.remove(index);
    this.menu.removeChild(getTopNode(childItem));
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
