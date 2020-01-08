/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiFlagMode;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.fx.widget.FxActiveWidget;
import io.github.mmm.ui.fx.widget.FxLabel;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.validation.ValidationResult;
import io.github.mmm.validation.Validator;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link TextField}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxInput<W extends Control, V> extends FxActiveWidget<W> implements UiInput<V> {

  private String fieldLabel;

  private FxLabel fieldLabelWidget;

  private String validationFailure;

  private Validator<? super V> validator;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxInput(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
    this.validator = Validator.none();
  }

  @Override
  public String getFieldLabel() {

    if (this.fieldLabelWidget == null) {
      return this.fieldLabel;
    } else {
      return this.fieldLabelWidget.getLabel();
    }
  }

  @Override
  public void setFieldLabel(String label) {

    if (this.fieldLabelWidget == null) {
      this.fieldLabel = label;
    } else {
      this.fieldLabelWidget.setLabel(label);
    }
  }

  @Override
  public boolean hasFieldLabelWidget() {

    return (this.fieldLabelWidget != null);
  }

  @Override
  public UiLabel getFieldLabelWidget() {

    if (this.fieldLabelWidget == null) {
      this.fieldLabelWidget = new FxLabel(this.context);
      if (this.fieldLabel != null) {
        this.fieldLabelWidget.setLabel(this.fieldLabel);
      }
      doSetVisibleState(this.fieldLabelWidget, doGetVisibleState(this));
      String id = getId();
      if (id != null) {
        this.fieldLabelWidget.setId(id + "_label");
      }
    }
    return this.fieldLabelWidget;
  }

  @Override
  public void setVisible(boolean visible, UiFlagMode flagMode) {

    super.setVisible(visible, flagMode);
    if (this.fieldLabelWidget != null) {
      this.fieldLabelWidget.setVisible(visible, flagMode);
    }
  }

  @Override
  public boolean isReadOnly() {

    return this.nativeWidget.getPseudoClassStates().contains(CLASS_READ_ONLY) && isEditable();
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    setEditable(readOnly);
    this.nativeWidget.pseudoClassStateChanged(CLASS_READ_ONLY, readOnly);
  }

  @Override
  public String getValidationFailure() {

    return this.validationFailure;
  }

  @Override
  public void setValidationFailure(String error) {

    boolean invalid;
    if ((error == null) || (error.isBlank())) {
      this.validationFailure = null;
      invalid = false;
    } else {
      this.validationFailure = error;
      invalid = true;
    }
    this.nativeWidget.pseudoClassStateChanged(CLASS_INVALID, invalid);
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.validator;
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    if (validator == null) {
      this.validator = Validator.none();
    } else {
      this.validator = validator;
    }
  }

  /**
   * Performs a validation and updates the {@link #getValidationFailure() validation failure message}.
   */
  public void validate() {

    ValidationResult validationResult = this.validator.validate(getValue());
    String message = validationResult.getLocalizedMessage();
    setValidationFailure(message);
  }

  @Override
  protected void onFocusChanged(boolean focusGain) {

    validate();
    super.onFocusChanged(focusGain);
  }

  /**
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected void onValueChange(ObservableValue<? extends V> observable, V oldValue, V newValue) {

    fireEvent(new UiValueChangeEvent(this, getProgrammaticEventType() == UiValueChangeEvent.TYPE));
  }

}
