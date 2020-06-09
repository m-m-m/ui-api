/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.input.UiInputContainer;

/**
 * {@link AbstractUiCustomWidget} adapting a {@link UiInput}. Extend it to build reusable custom {@link UiInput}s.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public class UiCustomInput<V, W extends UiInput<V>> extends UiCustomValidatableWidget<V, W> implements UiInput<V> {

  /**
   * The constructor.
   *
   * @param delegate the {@link UiInput} to wrap.
   */
  public UiCustomInput(W delegate) {

    super(delegate);
  }

  @Override
  public String getTooltip() {

    return this.delegate.getTooltip();
  }

  @Override
  public void setTooltip(String tooltip) {

    this.delegate.setTooltip(tooltip);
  }

  @Override
  public String getName() {

    return this.delegate.getName();
  }

  @Override
  public void setName(String name) {

    this.delegate.setName(name);
  }

  @Override
  public boolean hasNameWidget() {

    return this.delegate.hasNameWidget();
  }

  @Override
  public UiLabel getNameWidget() {

    return this.delegate.getNameWidget();
  }

  @Override
  public boolean hasContainerWidget() {

    return this.delegate.hasContainerWidget();
  }

  @Override
  public UiInputContainer<V> getContainerWidget() {

    return this.delegate.getContainerWidget();
  }

}
