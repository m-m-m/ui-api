/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.widget.attribute.UiWidgetWithClick;

/**
 * Implementation of {@link io.github.mmm.ui.widget.attribute.UiWidgetWithClick} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmClickableWidget<W extends HTMLElement> extends TvmActiveWidget<W>
    implements UiWidgetWithClick {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmClickableWidget(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.addEventListener(EVENT_TYPE_CLICK, this::onClick);
  }

  @Override
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

}
