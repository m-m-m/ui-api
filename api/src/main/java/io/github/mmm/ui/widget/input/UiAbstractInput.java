/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.datatype.UiFlagMode;
import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.UiAtomicWidget;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.value.UiValuedWidget;
import io.github.mmm.validation.Validator;

/**
 * {@link UiValuedWidget} for an {@link UiAtomicWidget atomic} input field.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiAbstractInput<V> extends UiValuedWidget<V>, UiActiveWidget, UiRegularWidget {

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
   * @return {@code true} if this input widget is editable (value can be edited by the end-user similar if not
   *         {@link #isEnabled() enabled} but typically without visual differences such as grayed out), {@code false}
   *         otherwise.
   */
  default boolean isEditable() {

    return isEnabled(UiFlagMode.READ_ONLY);
  }

  /**
   * <b>ATTENTION:</b> {@link #isReadOnly() read-only} and {@link #isEditable() editable} are not independent states.
   * Setting to read-only and then setting to editable can have undesired effects. Therefore avoid to mix using both
   * states if possible.
   *
   * @param editable the new value of {@link #isEditable()}.
   */
  default void setEditable(boolean editable) {

    setEnabled(editable, UiFlagMode.READ_ONLY);
  }

  /**
   * @return {@code true} if this input widget is read-only (value can not be edited by the user and is displayed as
   *         view only like a label), {@code false} otherwise.
   */
  default boolean isReadOnly() {

    return isEditable();
  }

  /**
   * @param readOnly the new value of {@link #isReadOnly()}.
   * @see #setEditable(boolean)
   */
  default void setReadOnly(boolean readOnly) {

    setEditable(readOnly);
  }

  /**
   * @return {@code true} if valid (no {@link UiInput#getValidationFailure() validation failure} is present),
   *         {@code false} otherwise.
   */
  default boolean isValid() {

    return (getValidationFailure() == null);
  }

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
