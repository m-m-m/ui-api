/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.attribute.UiWidgetWithLabel;

/**
 * {@link TvmInput} that also implements {@link UiWidgetWithLabel}.
 *
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class TvmLabelledInput<V> extends TvmHtmlInput<V> implements UiWidgetWithLabel {

  private final HTMLElement topWidget;

  private final HTMLElement labelWidget;

  private String label;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param type the {@link HTMLInputElement#getType() type} of the input.
   * @param tag the {@link HTMLElement#getTagName() tag name} of the {@link #getTopWidget() top widget}.
   */
  public TvmLabelledInput(UiContext context, String type, String tag) {

    super(context, type);
    this.topWidget = newElement(tag);
    this.labelWidget = newLabel();
    this.topWidget.appendChild(this.widget);
    this.topWidget.appendChild(this.labelWidget);
    this.label = "";
  }

  @Override
  public void setId(String id) {

    super.setId(id);
    this.labelWidget.setAttribute("for", id);
  }

  @Override
  public HTMLElement getTopWidget() {

    return this.topWidget;
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
    this.label = label;
    setTextContent(this.labelWidget, label);
  }

}
