/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.UiAtomicWidget;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.value.UiValuedWidget;
import io.github.mmm.validation.Validator;

/**
 * {@link UiValuedWidget} for an {@link UiAtomicWidget atomic} input field.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiInput<V> extends UiValuedWidget<V>, UiActiveWidget, UiAtomicWidget {

  /**
   * @return the {@link UiLabel#getLabel() label} for the {@link #getFieldLabelWidget() field label widget}.
   */
  String getFieldLabel();

  /**
   * @param label the new {@link #getFieldLabel() field label}. Prevents lazy initialization of the
   *        {@link #getFieldLabelWidget() field label widget}.
   */
  void setFieldLabel(String label);

  /**
   * @return {@code true} if the {@link #getFieldLabelWidget() field label widget} has already been created,
   *         {@code false} otherwise. Helpful to avoid unintended lazy initialization.
   */
  boolean hasFieldLabelWidget();

  /**
   * @return the {@link UiLabel} of this input field.
   */
  UiLabel getFieldLabelWidget();

  /**
   * @return the validation error text or {@code null} for no error.
   */
  String getValidationFailure();

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
