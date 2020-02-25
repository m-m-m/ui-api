/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiFocusGainEvent;
import io.github.mmm.ui.event.UiFocusLossEvent;
import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * Implementation of {@link io.github.mmm.ui.widget.UiActiveWidget} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmActiveWidget<W extends HTMLElement> extends TvmWidgetHtmlElement<W> implements UiActiveWidget {

  private char accessKey;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmActiveWidget(UiContext context, W widget) {

    super(context, widget);
    this.accessKey = ACCESS_KEY_NONE;
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    if (parent != null) {
      ensureHandlers();
    }
    super.setParent(parent);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.addEventListener(EVENT_TYPE_FOCUS, this::onFocusGain);
    this.widget.addEventListener(EVENT_TYPE_BLUR, this::onFocusLoss);
  }

  /**
   * @param event the focus {@link Event}.
   */
  protected void onFocusGain(Event event) {

    fireEvent(new UiFocusGainEvent(this, false));
  }

  /**
   * @param event the blur {@link Event}.
   */
  protected void onFocusLoss(Event event) {

    fireEvent(new UiFocusLossEvent(this, false));
  }

  @Override
  public char getAccessKey() {

    return this.accessKey;
  }

  @Override
  public void setAccessKey(char accessKey) {

    this.widget.setAccessKey(Character.toString(accessKey));
  }

  @Override
  public boolean isFocused() {

    HTMLElement activeElement = Window.current().getDocument().getActiveElement();
    return (activeElement == this.widget);
  }

  @Override
  public boolean setFocused() {

    this.widget.focus();
    return true;
  }

}
