/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.BitMask;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.fx.widget.FxActiveWidget;
import io.github.mmm.ui.fx.widget.FxLabel;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.validation.Validator;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;

/**
 * Implementation of {@link UiInput} using JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxInput<W extends Control, V> extends FxActiveWidget<W> implements UiInput<V> {

  private String name;

  private FxLabel nameWidget;

  private String validationFailure;

  private Validator<? super V> validator;

  private V originalValue;

  private boolean modified;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxInput(UiContext context, W widget) {

    super(context, widget);
    this.validator = Validator.none();
  }

  @Override
  public String getName() {

    if (this.nameWidget == null) {
      return this.name;
    } else {
      return this.nameWidget.getLabel();
    }
  }

  @Override
  public void setName(String name) {

    if (this.nameWidget == null) {
      this.name = name;
    } else {
      this.nameWidget.setLabel(name);
    }
  }

  @Override
  public boolean hasNameWidget() {

    return (this.nameWidget != null);
  }

  @Override
  public UiLabel getNameWidget() {

    if (this.nameWidget == null) {
      this.nameWidget = new FxLabel(this.context);
      if (this.name != null) {
        this.nameWidget.setLabel(this.name);
      }
      doSetVisibleState(this.nameWidget, doGetVisibleState(this));
      String id = getId();
      if (id != null) {
        this.nameWidget.setId(id + "_label");
      }
    }
    return this.nameWidget;
  }

  @Override
  public void setVisible(boolean visible, BitMask flagMode) {

    super.setVisible(visible, flagMode);
    if (this.nameWidget != null) {
      this.nameWidget.setVisible(visible, flagMode);
    }
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
    this.widget.pseudoClassStateChanged(CLASS_INVALID, invalid);
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

  @Override
  public boolean isModified() {

    return this.modified;
  }

  @Override
  public void setValue(V value) {

    this.modified = false;
    setOriginalValue(value);
    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    setValueNative(value);
  }

  @Override
  public void setValueForUser(V value) {

    this.modified = true;
    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    setValueNative(value);
  }

  /**
   * @param value the new {@link #getValue() value} to set in the native widget.
   */
  protected abstract void setValueNative(V value);

  /**
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected void onValueChange(ObservableValue<? extends V> observable, V oldValue, V newValue) {

    boolean programmatic = getProgrammaticEventType() == UiValueChangeEvent.TYPE;
    if (!programmatic) {
      this.modified = true;
    }
    fireEvent(new UiValueChangeEvent(this, programmatic));
  }

  @Override
  protected void onFocusChanged(boolean focusGain) {

    if (!focusGain) {
      validate();
    }
    super.onFocusChanged(focusGain);
  }

}
