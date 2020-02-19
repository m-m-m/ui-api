/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.composite;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiEnabledFlags;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * Implementation of {@link UiDynamicComposite} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class TvmDynamicComposite<W extends HTMLElement, C extends UiWidget> extends TvmComposite<W, C>
    implements UiDynamicComposite<C> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmDynamicComposite(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  public void addChild(C child, int index) {

    setParent(child, this);
    addChildWidget(child, index);
    if (index == -1) {
      this.children.add(child);
    } else {
      this.children.add(index, child);
    }
  }

  /**
   * @param child the widget to add as child to the DOM.
   * @param index the index where to insert the child.
   * @see #addChild(UiWidget, int)
   */
  protected void addChildWidget(C child, int index) {

    insertAt(this.widget, getTopNode(child), index);
  }

  @Override
  public boolean removeChild(C child) {

    boolean removed = this.children.remove(child);
    if (removed) {
      removeChildWidget(child);
      setParent(child, null);
    }
    return removed;
  }

  @Override
  public C removeChild(int index) {

    C child = this.children.remove(index);
    removeChildWidget(child);
    setParent(child, null);
    return child;
  }

  /**
   * @param child the widget to remove as child from the DOM.
   * @see #removeChild(UiWidget)
   * @see #removeChild(int)
   */
  protected void removeChildWidget(C child) {

    this.widget.removeChild(getTopNode(child));
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    for (C child : this.children) {
      child.setEnabled(enabled, UiEnabledFlags.PARENT);
    }
  }

}
