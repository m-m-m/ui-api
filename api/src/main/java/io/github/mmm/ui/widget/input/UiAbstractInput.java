/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiAtomicWidget;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.value.UiValidatableWidget;
import io.github.mmm.ui.widget.value.UiValuedWidget;
import io.github.mmm.validation.Validator;

/**
 * {@link UiValuedWidget} for an {@link UiAtomicWidget atomic} input field.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiAbstractInput<V> extends UiValidatableWidget<V>, UiRegularWidget {

  /**
   * @return the {@link UiLabel#getLabel() label} for the {@link #getNameWidget() field label widget}.
   */
  String getName();

  /**
   * @param name the new {@link #getName() field label}. Prevents lazy initialization of the {@link #getNameWidget()
   *        field label widget}.
   */
  void setName(String name);

  /**
   * @return {@code true} if the {@link #getNameWidget() name widget} has already been created, {@code false} otherwise.
   *         Helpful to avoid unintended lazy initialization.
   */
  boolean hasNameWidget();

  /**
   * @return the {@link UiLabel} of this input. May be lazily created on the first call of this method to avoid
   *         unnecessary overhead (e.g. if a {@link UiInput} is used for inline editing).
   */
  UiLabel getNameWidget();

  /**
   * @param validationFailure is the validation failure text. The empty string or {@code null} will clear the error and
   *        mark the field as valid. Otherwise the field will be invalid.
   */
  void setValidationFailure(String validationFailure);

  /**
   * @return the {@link Validator} to validate the {@link #getValue() value} of this input.
   */
  Validator<? super V> getValidator();

  /**
   * @param validator the new {@link #getValidator() validator}.
   */
  void setValidator(Validator<? super V> validator);

}
