/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextualInput;

/**
 * Implementation of {@link UiTextualInput} using TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmTextualInput<W extends HTMLInputElement> extends TvmInput<String, W>
    implements UiTextualInput {

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

  @Override
  public String getValue() {

    return this.widget.getValue();
  }

  @Override
  protected void setValueNative(String value) {

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
