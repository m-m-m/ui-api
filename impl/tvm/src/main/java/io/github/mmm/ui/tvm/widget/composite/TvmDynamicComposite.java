/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.composite;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
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
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public TvmDynamicComposite(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  public void addChild(C child, int index) {

    setParent(child, this);
    this.widget.appendChild(getTopNode(child));
    this.children.add(index, child);
  }

  @Override
  public boolean removeChild(C child) {

    boolean removed = this.children.remove(child);
    if (removed) {
      this.widget.removeChild(getTopNode(child));
      setParent(child, null);
    }
    return removed;
  }

  @Override
  public C removeChild(int index) {

    C child = this.children.remove(index);
    this.widget.removeChild(getTopNode(child));
    setParent(child, null);
    return child;
  }

}
