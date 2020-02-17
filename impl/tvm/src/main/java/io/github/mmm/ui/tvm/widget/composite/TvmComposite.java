/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.composite;

import java.util.ArrayList;
import java.util.List;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.TvmWidgetHtmlElement;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * Implementation of {@link UiComposite} using TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class TvmComposite<W extends HTMLElement, C extends UiWidget> extends TvmWidgetHtmlElement<W>
    implements UiComposite<C> {

  /** @see #getChild(int) */
  protected final List<C> children;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmComposite(UiContext context, W widget) {

    super(context, widget);
    this.children = new ArrayList<>();
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public C getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public int getChildIndex(C child) {

    if (child == null) {
      return -1;
    }
    return this.children.indexOf(child);
  }

}
