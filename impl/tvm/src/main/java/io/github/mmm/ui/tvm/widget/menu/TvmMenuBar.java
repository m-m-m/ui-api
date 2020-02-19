/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.menu.UiMenuBar;

/**
 * Implementation of {@link UiMenuBar} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMenuBar extends TvmDynamicComposite<HTMLElement, UiMenu> implements UiMenuBar {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public TvmMenuBar(UiContext context, HTMLElement widget) {

    super(context, widget);
    this.widget.setAttribute(ATR_ROLE, "menubar");
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMenuBar(UiContext context) {

    this(context, newElement("ui-menubar"));
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    // TODO Auto-generated method stub

  }

}
