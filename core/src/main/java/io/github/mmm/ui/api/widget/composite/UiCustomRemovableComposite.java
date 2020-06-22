/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiCustomComposite} that is a {@link UiRemovableComposite}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public abstract class UiCustomRemovableComposite<C extends UiWidget, W extends UiRemovableComposite<C>>
    extends UiCustomComposite<C, W> implements UiRemovableComposite<C> {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomRemovableComposite(W delegate) {

    super(delegate);
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
