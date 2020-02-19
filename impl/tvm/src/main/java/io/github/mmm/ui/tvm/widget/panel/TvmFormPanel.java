/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;

/**
 * Implementation of {@link UiFormPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmFormPanel extends TvmDynamicComposite<HTMLElement, UiAbstractInput<?>> implements UiFormPanel {

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
  protected void addChildWidget(UiAbstractInput<?> child, int index) {

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
      UiInput<?> input = (UiInput<?>) child;
      insertAt(this.widget, getTopNode(input.getNameWidget()), domIndex);
      if (domIndex >= 0) {
        domIndex++;
      }
    }
    insertAt(this.widget, getTopNode(child), domIndex);
  }

  @Override
  protected void removeChildWidget(UiAbstractInput<?> child) {

    this.widget.removeChild(getTopNode(child));
    if (child instanceof UiInput) {
      UiInput<?> input = (UiInput<?>) child;
      this.widget.removeChild(getTopNode(input.getNameWidget()));
    }
  }

}
