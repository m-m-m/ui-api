/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.custom;

import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiCustomWidget} that is a {@link UiDynamicComposite}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class UiCustomDynamicComposite<W extends UiDynamicComposite<C>, C extends UiWidget>
    extends UiCustomComposite<W, C> implements UiDynamicComposite<C> {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomDynamicComposite(W delegate) {

    super(delegate);
  }

  @Override
  public void addChild(C child) {

    this.delegate.addChild(child);
  }

  @Override
  public void addChild(C child, int index) {

    this.delegate.addChild(child, index);
  }

  @Override
  public boolean removeChild(C child) {

    return this.delegate.removeChild(child);
  }

  @Override
  public C removeChild(int index) {

    return this.delegate.removeChild(index);
  }

}
