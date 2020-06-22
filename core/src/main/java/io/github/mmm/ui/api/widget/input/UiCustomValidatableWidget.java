/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;
import io.github.mmm.validation.Validator;

/**
 * {@link AbstractUiCustomWidget} adapting a {@link UiValidatableWidget}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class UiCustomValidatableWidget<V, W extends UiValidatableWidget<V>> extends UiCustomValuedWidget<V, W>
    implements UiValidatableWidget<V> {

  /**
   * The constructor.
   *
   * @param delegate the {@link #getDelegate() delegate}.
   */
  public UiCustomValidatableWidget(W delegate) {

    super(delegate);
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

  @Override
  public void setValidationFailure(String validationFailure, boolean valueException) {

    this.delegate.setValidationFailure(validationFailure, valueException);
  }

}
