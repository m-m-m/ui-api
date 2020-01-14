/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
import io.github.mmm.ui.widget.UiClickableWidget;

/**
 * Implementation of {@link io.github.mmm.ui.widget.UiClickableWidget} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmClickableWidget<W extends HTMLElement> extends TvmActiveWidget<W>
    implements UiClickableWidget {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public TvmClickableWidget(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.addEventListener("click", this::onClick);
  }

  /**
   * @param event the click {@link Event}.
   */
  protected void onClick(Event event) {

    fireEvent(new UiClickEvent(this, false));
  }

  @Override
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

}
