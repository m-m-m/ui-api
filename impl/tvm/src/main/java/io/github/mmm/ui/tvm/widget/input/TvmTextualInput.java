/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextualInput;

/**
 * Implementation of {@link UiTextualInput} using TeaVM.
 *
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class TvmTextualInput<V> extends TvmHtmlInput<V> implements UiTextualInput<V> {

  private String placeholder;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param type the {@link HTMLInputElement#getType() type} of the input.
   */
  public TvmTextualInput(UiContext context, String type) {

    super(context, type);
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmTextualInput(UiContext context, HTMLInputElement widget) {

    super(context, widget);
  }

  @Override
  public String getText() {

    return this.widget.getValue();
  }

  @Override
  public void setText(String value) {

    this.widget.setValue(value);
  }

  @Override
  public String getPlaceholder() {

    return this.placeholder;
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.placeholder = placeholder;
    // this.nativeWidget.setPlaceholder(placeholder);
  }

}