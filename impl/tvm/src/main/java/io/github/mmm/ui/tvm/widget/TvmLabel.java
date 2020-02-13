/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiLabel;

/**
 * Implementation of {@link UiLabel} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmLabel extends TvmWidgetHtmlElement<HTMLElement> implements UiLabel {

  private String label;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmLabel(UiContext context) {

    super(context, newLabel());
  }

  @Override
  public String getLabel() {

    return this.label;
  }

  @Override
  public void setLabel(String label) {

    setTextContent(label);
    this.label = label;
  }

  /**
   * @param id the ID of the input widget associated with this label.
   */
  public void setFor(String id) {

    this.widget.setAttribute("for", id);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

  }
}
