/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiMutableComposite}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public abstract class UiCustomMutableSingleComposite<C extends UiWidget, W extends UiMutableSingleComposite<C>>
    extends UiCustomComposite<C, W> implements UiMutableSingleComposite<C> {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomMutableSingleComposite(W delegate) {

    super(delegate);
  }

  @Override
  public C getChild() {

    return getDelegate().getChild();
  }

  @Override
  public void setChild(C child) {

    getDelegate().setChild(child);
  }

}
