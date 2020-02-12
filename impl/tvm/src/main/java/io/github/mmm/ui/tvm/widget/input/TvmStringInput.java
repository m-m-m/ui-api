/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiStringInput;

/**
 * Implementation of {@link UiStringInput} using TeaVM.
 *
 * @since 1.0.0
 */
public abstract class TvmStringInput extends TvmTextualInput<String> implements UiStringInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param type the {@link HTMLInputElement#getType() type} of the input.
   */
  public TvmStringInput(UiContext context, String type) {

    super(context, type);
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmStringInput(UiContext context, HTMLInputElement widget) {

    super(context, widget);
  }

  @Override
  public String getValue() {

    return this.widget.getValue();
  }

  @Override
  protected void setValueNative(String value) {

    this.widget.setValue(value);
  }

}
