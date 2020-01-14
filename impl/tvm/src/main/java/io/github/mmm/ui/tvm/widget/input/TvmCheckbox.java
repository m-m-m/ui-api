/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiTextInput;

/**
 * Implementation of {@link UiTextInput} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmCheckbox extends TvmInput<Boolean, HTMLInputElement> implements UiCheckbox {

  private String label;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmCheckbox(UiContext context) {

    super(context, "checkbox");
  }

  @Override
  public String getLabel() {

    return this.label;
  }

  @Override
  public void setLabel(String label) {

    this.label = label;
    setTextContent(label);
  }

  @Override
  public Boolean getValue() {

    return Boolean.valueOf(this.widget.isChecked());
  }

  @Override
  protected void setValueNative(Boolean value) {

    this.widget.setChecked(Boolean.TRUE.equals(value));
  }

}
