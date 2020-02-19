/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.TvmClickableWidget;
import io.github.mmm.ui.widget.menu.UiAbstractActiveMenuItem;

/**
 * Implementation of {@link UiAbstractActiveMenuItem} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmAbstractActiveMenuItem<W extends HTMLElement> extends TvmClickableWidget<W>
    implements UiAbstractActiveMenuItem {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmAbstractActiveMenuItem(UiContext context, W widget) {

    super(context, widget);
    this.widget.setAttribute(ATR_ROLE, "menuitem");
  }

}
