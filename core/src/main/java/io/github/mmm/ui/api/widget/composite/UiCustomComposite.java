/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiComposite}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public class UiCustomComposite<C extends UiWidget, W extends UiComposite<C>> extends AbstractUiCustomWidget<W>
    implements UiComposite<C> {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomComposite(W delegate) {

    super(delegate);
  }

  @Override
  public int getChildCount() {

    return this.delegate.getChildCount();
  }

  @Override
  public C getChild(int index) {

    return this.delegate.getChild(index);
  }

  @Override
  public int getChildIndex(C child) {

    return this.delegate.getChildIndex(child);
  }

  @Override
  public C getChild(String id) {

    return this.delegate.getChild(id);
  }

}
