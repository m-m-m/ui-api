/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.TvmWidgetHtmlElement;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.panel.UiFormGroup;

/**
 * Implementation of {@link UiFormGroup} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmFormGroup extends TvmDynamicComposite<HTMLElement, UiInput<?>> implements UiFormGroup {

  private final Legend legend;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmFormGroup(UiContext context) {

    this(context, newFieldSet());
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmFormGroup(UiContext context, HTMLElement widget) {

    super(context, widget);
    this.legend = new Legend(context);
    this.widget.appendChild(this.legend.getTopWidget());
  }

  @Override
  protected void addChildWidget(UiInput<?> child, int index) {

    int domIndex = index;
    if (domIndex >= 0) {
      domIndex = (index * 2) + 1; // legend is first child, then 2 child nodes per UiInput
    }
    insertAt(this.widget, getTopNode(child.getNameWidget()), domIndex);
    if (domIndex >= 0) {
      domIndex++;
    }
    insertAt(this.widget, getTopNode(child), domIndex);
  }

  @Override
  protected void removeChildWidget(UiInput<?> child) {

    this.widget.removeChild(getTopNode(child.getNameWidget()));
    this.widget.removeChild(getTopNode(child));
  }

  @Override
  public String getName() {

    return this.legend.getLabel();
  }

  @Override
  public void setName(String name) {

    this.legend.setLabel(name);
  }

  @Override
  public boolean isCollapsed() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setCollapsed(boolean collapsed) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isCollapsible() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setCollapsible(boolean collapsible) {

    // TODO Auto-generated method stub

  }

  private static class Legend extends TvmWidgetHtmlElement<HTMLElement> implements UiLabel {

    private final HTMLElement topWidget;

    private String label;

    /**
     * The constructor.
     *
     * @param context the {@link #getContext() context}.
     */
    public Legend(UiContext context) {

      super(context, newLabel());
      this.topWidget = newLegend();
      this.topWidget.appendChild(this.widget);
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

      setTextContent(label);
      this.label = label;
    }

    @Override
    protected void setEnabledNative(boolean enabled) {

    }
  }

}
