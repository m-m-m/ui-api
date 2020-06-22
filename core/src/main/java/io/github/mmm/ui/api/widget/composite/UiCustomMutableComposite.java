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
public abstract class UiCustomMutableComposite<C extends UiWidget, W extends UiMutableComposite<C>>
    extends UiCustomRemovableComposite<C, W> implements UiMutableComposite<C> {

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

}
