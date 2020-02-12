/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmComposite;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.menu.UiMenuBar;

/**
 * Implementation of {@link UiMenuBar} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMenuBar extends TvmComposite<HTMLElement, UiMenu> implements UiMenuBar {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public TvmMenuBar(UiContext context, HTMLElement widget) {

    super(context, widget);
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMenuBar(UiContext context) {

    super(context, Window.current().getDocument().createElement("ui-menu"));
  }

  @Override
  public void addChild(UiMenu child, int index) {

    // TODO: add to DOM
    this.children.add(index, child);
  }

  @Override
  public UiMenu removeChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    UiMenu menu = this.children.remove(index);
    // TODO: remove from dom DOM
    // this.widget.removeChild(getTopNode(menu));
    return menu;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    // TODO Auto-generated method stub

  }

}
