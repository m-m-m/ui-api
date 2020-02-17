/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;

/**
 * Implementation of {@link UiVerticalPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmFormPanel extends TvmFailureComposite<UiAbstractInput<?>> implements UiFormPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmFormPanel(UiContext context) {

    super(context, newForm());
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmFormPanel(UiContext context, HTMLElement widget) {

    super(context, widget);
  }

  @Override
  protected void addChildToDom(UiAbstractInput<?> child, int index) {

    int domIndex = -1;
    if (index >= 0) {
      domIndex = 0;
      for (int i = 0; i < index; i++) {
        UiAbstractInput<?> input = this.children.get(i);
        domIndex++;
        if (input instanceof UiInput) {
          domIndex++;
        }
      }
    }
    if (child instanceof UiInput) {
      insertAt(this.widget, getTopNode(child.getNameWidget()), domIndex);
      if (domIndex >= 0) {
        domIndex++;
      }
    }
    insertAt(this.widget, getTopNode(child), domIndex);
  }

  @Override
  protected void removeChildFromDom(UiAbstractInput<?> child) {

    this.widget.removeChild(getTopNode(child));
    if (child instanceof UiInput) {
      this.widget.removeChild(getTopNode(child.getNameWidget()));
    }
  }

}
