/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.widget.value.UiValuedWidget;

/**
 * {@link AbstractUiCustomWidget} adapting a {@link UiValuedWidget}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class UiCustomValuedWidget<V, W extends UiValuedWidget<V>> extends AbstractUiCustomWidget<W>
    implements UiValuedWidget<V> {

  /**
   * The constructor.
   *
   * @param delegate the {@link #getDelegate() delegate}.
   */
  public UiCustomValuedWidget(W delegate) {

    super(delegate);
  }

  @Override
  public V getValue() {

    return this.delegate.getValue();
  }

  @Override
  public void setValue(V value) {

    this.delegate.setValue(value);
  }

}
