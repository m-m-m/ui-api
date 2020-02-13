/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLTextAreaElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextArea;

/**
 * Implementation of {@link UiTextArea} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmTextArea extends TvmInput<String, HTMLTextAreaElement> implements UiTextArea {

  private String placeholder;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmTextArea(UiContext context) {

    super(context, newTextArea());
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
    // widget.setPlaceholder(placeholder);

  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

}
