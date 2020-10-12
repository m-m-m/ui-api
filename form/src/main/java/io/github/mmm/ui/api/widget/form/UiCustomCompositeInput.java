/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.input.UiCustomInput;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public class UiCustomCompositeInput<V, W extends UiCompositeInput<V>> extends UiCustomInput<V, W>
    implements UiCompositeInput<V> {

  /**
   * The constructor.
   *
   * @param delegate the {@link #getDelegate() delegate}.
   */
  public UiCustomCompositeInput(W delegate) {

    super(delegate);
  }

  @Override
  public void initBinding(UiValueBinding<V> binding) {

    this.delegate.initBinding(binding);
  }

  @Override
  public void addChild(UiRegularWidget child, int index) {

    this.delegate.addChild(child, index);
  }

  @Override
  public UiRegularWidget removeChild(int index) {

    return this.delegate.removeChild(index);
  }

  @Override
  public int getChildCount() {

    return this.delegate.getChildCount();
  }

  @Override
  public UiRegularWidget getChild(int index) {

    return this.delegate.getChild(index);
  }

  @Override
  public int getChildIndex(UiRegularWidget child) {

    return this.delegate.getChildIndex(child);
  }

}
