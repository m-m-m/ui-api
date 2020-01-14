/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.BitMask;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.tvm.widget.TvmActiveWidget;
import io.github.mmm.ui.tvm.widget.TvmLabel;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link UiInput} using TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class TvmInput<V, W extends HTMLInputElement> extends TvmActiveWidget<W> implements UiInput<V> {

  private String name;

  private TvmLabel nameWidget;

  private String validationFailure;

  private Validator<? super V> validator;

  private V originalValue;

  private boolean modified;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param type the {@link HTMLInputElement#getType() type} of the input.
   */
  public TvmInput(UiContext context, String type) {

    super(context, Window.current().getDocument().createElement("input").cast());
    this.widget.setType(type);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.addEventListener("change", this::onChange);
  }

  /**
   * @param event the change {@link Event}.
   */
  protected void onChange(Event event) {

    fireEvent(new UiValueChangeEvent(this, getProgrammaticEventType() == UiValueChangeEvent.TYPE));
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
  public void setId(String id) {

    super.setId(id);
    if (this.nameWidget != null) {
      this.nameWidget.setFor(id);
    }
  }

  @Override
  public boolean hasNameWidget() {

    return (this.nameWidget != null);
  }

  @Override
  public UiLabel getNameWidget() {

    if (this.nameWidget == null) {
      this.nameWidget = new TvmLabel(this.context);
      if (this.name != null) {
        this.nameWidget.setLabel(this.name);
      }
      doSetVisibleState(this.nameWidget, doGetVisibleState(this));
      String id = getId();
      if (id != null) {
        this.nameWidget.setFor(id);
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
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisabled(!enabled);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    this.widget.setReadOnly(readOnly);
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

    if ((error == null) || (error.isBlank())) {
      error = null;
    }
    this.validationFailure = error;
    setCustomValidity(this.widget, error);
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

  @Override
  protected void onFocusLoss(Event event) {

    validate();
    super.onFocusLoss(event);
  }

  @JSBody(params = { "input", "value" }, script = "input.setCustomValidity(value);")
  private static native void setCustomValidity(HTMLInputElement input, String value);
}
