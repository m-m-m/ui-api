/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.menu;

import org.teavm.jso.dom.html.HTMLButtonElement;

import io.github.mmm.ui.UiContext;

/**
 *
 */
public abstract class TvmAbstractButtonMenuItem extends TvmAbstractActiveMenuItem<HTMLButtonElement> {

  private String label;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmAbstractButtonMenuItem(UiContext context, HTMLButtonElement widget) {

    super(context, widget);
    this.label = "";
  }

  @Override
  public String getLabel() {

    return this.label;
  }

  @Override
  public void setLabel(String label) {

    if (label == null) {
      label = "";
    }
    setTextContent(label);
    this.label = label;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

}
