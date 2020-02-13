/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Implementation of {@link UiInput} using TeaVM based on {@link HTMLInputElement}.
 *
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class TvmHtmlInput<V> extends TvmInput<V, HTMLInputElement> {

  /** {@link HTMLInputElement#getType() Type} of text input. */
  public static final String TYPE_TEXT = "text";

  /** {@link HTMLInputElement#getType() Type} of radio (button) input. */
  public static final String TYPE_RADIO = "radio";

  /** {@link HTMLInputElement#getType() Type} of checkbox input. */
  public static final String TYPE_CHECKBOX = "checkbox";

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param type the {@link HTMLInputElement#getType() type} of the input.
   */
  public TvmHtmlInput(UiContext context, String type) {

    super(context, newInput());
    this.widget.setType(type);
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmHtmlInput(UiContext context, HTMLInputElement widget) {

    super(context, widget);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

}
