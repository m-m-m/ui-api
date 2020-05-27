/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiMutableComposite}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public abstract class UiCustomMutableComposite<C extends UiWidget, W extends UiMutableComposite<C>>
    extends UiCustomComposite<W, C> implements UiMutableComposite<C> {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomMutableComposite(W delegate) {

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
