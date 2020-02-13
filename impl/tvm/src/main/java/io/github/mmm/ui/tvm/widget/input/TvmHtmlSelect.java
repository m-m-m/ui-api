/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLSelectElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Implementation of {@link UiInput} using TeaVM based on {@link HTMLSelectElement}.
 *
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class TvmHtmlSelect<V> extends TvmInput<V, HTMLSelectElement> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmHtmlSelect(UiContext context) {

    super(context, newSelect());
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmHtmlSelect(UiContext context, HTMLSelectElement widget) {

    super(context, widget);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

}
