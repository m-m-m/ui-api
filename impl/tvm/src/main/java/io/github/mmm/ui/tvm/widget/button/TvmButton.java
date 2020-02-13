/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.button;

import org.teavm.jso.dom.html.HTMLButtonElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.TvmClickableWidget;
import io.github.mmm.ui.widget.button.UiButton;

/**
 *
 */
public class TvmButton extends TvmClickableWidget<HTMLButtonElement> implements UiButton {

  private String label;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmButton(UiContext context) {

    super(context, newButton());
  }

  @Override
  public String getLabel() {

    return this.label;
  }

  @Override
  public void setLabel(String label) {

    setTextContent(label);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

}
