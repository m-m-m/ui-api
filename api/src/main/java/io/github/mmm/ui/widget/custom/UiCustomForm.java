/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.custom;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.value.UiValidatableWidget;
import io.github.mmm.validation.Validator;

/**
 * {@link UiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomForm<V> extends UiCustomDynamicComposite<UiFormPanel, UiAbstractInput<?>>
    implements UiFormPanel, UiValidatableWidget<V> {

  private Validator<? super V> validator;

  private V value;

  private V originalValue;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public UiCustomForm(UiContext context) {

    super(context.createFormPanel());
    this.validator = Validator.none();
  }

  /**
   * The constructor.
   *
   * @param delegate the {@link UiFormPanel}.
   */
  public UiCustomForm(UiFormPanel delegate) {

    super(delegate);
  }

  @Override
  public V getValue() {

    return this.value;
  }

  @Override
  public void setValue(V value) {

    this.value = value;
  }

  @Override
  public void setValueForUser(V value) {

    this.value = value;
  }

  @Override
  public V getOriginalValue() {

    return this.originalValue;
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.originalValue = originalValue;
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.validator;
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    this.validator = validator;
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
