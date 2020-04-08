/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiValuedComposite;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;
import io.github.mmm.validation.Validator;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomValuedComposite<W extends UiValuedComposite<C, V>, C extends UiWidget, V>
    extends UiCustomDynamicComposite<W, C> implements UiValuedComposite<C, V> {

  /**
   * The constructor.
   *
   * @param delegate the {@link UiFormPanel}.
   */
  public UiCustomValuedComposite(W delegate) {

    super(delegate);
  }

  @Override
  public void initBinding(UiValueBinding<V> binding) {

    this.delegate.initBinding(binding);
  }

  @Override
  public V getValue() {

    return this.delegate.getValue();
  }

  @Override
  public V getValueOrThrow() {

    return this.delegate.getValueOrThrow();
  }

  @Override
  public void setValue(V value, boolean forUser) {

    this.delegate.setValue(value, forUser);
  }

  @Override
  public V getOriginalValue() {

    return this.delegate.getOriginalValue();
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.delegate.setOriginalValue(originalValue);
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.delegate.getValidator();
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    this.delegate.setValidator(validator);
  }

  @Override
  public String getValidationFailure() {

    return this.delegate.getValidationFailure();
  }

  @Override
  public void setValidationFailure(String validationFailure) {

    this.delegate.setValidationFailure(validationFailure);
  }

}
