/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.value;

import java.util.function.Consumer;

import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.action.UiActionDiscard;
import io.github.mmm.ui.api.event.action.UiActionReset;
import io.github.mmm.ui.api.event.action.UiActionSave;
import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiCustomEditorButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.validation.Validator;

/**
 * {@link AbstractUiCustomWidget Custom widget} that represents and editor allowing to display and edit an object.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomEditor<V> extends AbstractUiCustomWidget<UiVerticalPanel>
    implements UiValidatableWidget<V>, UiRegularWidget {

  private final UiValidatableWidget<V> form;

  private final Consumer<V> saveFunction;

  /**
   * The constructor.
   *
   * @param form the actual input form to edit the {@link #getValue() value}.
   * @param saveFunction the {@link Consumer} function to save the {@link #getValue() data}.
   */
  public UiCustomEditor(UiValidatableWidget<V> form, Consumer<V> saveFunction) {

    super(UiVerticalPanel.of());
    this.form = form;
    this.saveFunction = saveFunction;
    this.delegate.addChild((UiRegularWidget) form);
    UiActionSave saveAction = this::onSave;
    UiActionReset resetAction = new ResetAction();
    UiActionDiscard discardAction = new DiscardAction();
    UiCustomEditorButtonPanel buttonPanel = new UiCustomEditorButtonPanel(saveAction, resetAction, discardAction, this);
    this.delegate.addChild(buttonPanel);
    setReadOnly(true);
  }

  private void onSave(UiEvent event) {

    boolean valid = this.form.validate();
    if (valid) {
      V value = this.form.getValue();
      try {
        this.saveFunction.accept(value);
      } catch (Exception e) {
        // UiNotifier.get().showPopupOK(e);
        e.printStackTrace();
      }
      this.form.setValue(value);
      setReadOnly(true);
    } else {
      String validationFailure = this.form.getValidationFailure();
      // UiNotifier.get().showPopupOK(validationFailure);
      System.out.println(validationFailure);
    }
  }

  @Override
  public String getValidationFailure() {

    return this.form.getValidationFailure();
  }

  @Override
  public void setValidationFailure(String validationFailure, boolean valueException) {

    this.form.setValidationFailure(validationFailure, valueException);
  }

  @Override
  public V getValueOrThrow() {

    return this.form.getValueOrThrow();
  }

  @Override
  public void setValue(V value, boolean forUser) {

    this.form.setValue(value, forUser);
  }

  @Override
  public V getOriginalValue() {

    return this.form.getOriginalValue();
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.form.setOriginalValue(originalValue);
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.form.getValidator();
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    this.form.setValidator(validator);
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    super.setReadOnly(readOnly);
  }

  private class ResetAction implements UiActionReset {

    @Override
    public boolean requireConfirmation() {

      return UiCustomEditor.this.form.isModified();
    }

    @Override
    public void onEvent(UiEvent event) {

      if (!UiCustomEditor.this.form.isModified()) {
        return;
      }
      UiCustomEditor.this.form.reset();
    }
  }

  private class DiscardAction implements UiActionDiscard {

    @Override
    public boolean requireConfirmation() {

      return UiCustomEditor.this.form.isModified();
    }

    @Override
    public void onEvent(UiEvent event) {

      if (!UiCustomEditor.this.form.isModified()) {
        return;
      }
      UiCustomEditor.this.form.reset();
      setReadOnly(true);
    }
  }

}
