/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiPropagation;
import io.github.mmm.ui.datatype.UiValidState;
import io.github.mmm.ui.datatype.bitmask.BitFlag;
import io.github.mmm.ui.datatype.bitmask.BitMask;
import io.github.mmm.ui.datatype.bitmask.BitValueBoolean;
import io.github.mmm.ui.event.UiDisableEvent;
import io.github.mmm.ui.event.UiEnableEvent;
import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.event.UiEventType;
import io.github.mmm.ui.event.UiHideEvent;
import io.github.mmm.ui.event.UiShowEvent;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithValidationFailure;
import io.github.mmm.ui.widget.composite.UiComposite;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.value.UiValidatableWidget;
import io.github.mmm.ui.widget.window.UiAbstractWindow;
import io.github.mmm.validation.ValidationResult;
import io.github.mmm.validation.Validator;

/**
 * Abstract base implementation of {@link UiNativeWidget}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiNativeWidget extends AbstractUiWidget
    implements UiNativeWidget, UiWidgetWithValidationFailure {

  private static final BitFlag READ_ONLY = BitFlag.B00;

  private static final BitValueBoolean READ_ONLY_FIXED = BitValueBoolean.ofBoolean(1);

  private UiComposite<?> parent;

  private boolean handlersRegistered;

  private UiEventType programmaticEventType;

  private int visibleState;

  private int enabledState;

  private int readOnlyState;

  private String validationFailure;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public AbstractUiNativeWidget(UiContext context) {

    super(context);
    this.handlersRegistered = false;
    if (isInitiallyVisible()) {
      this.visibleState = 0;
    } else {
      this.visibleState = 1;
    }
    this.enabledState = 0;
  }

  /**
   * @return {@code true} if this widget is initially visible (locally native), {@code false} otherwise.
   */
  protected boolean isInitiallyVisible() {

    return !(this instanceof UiAbstractWindow);
  }

  @Override
  public UiComposite<?> getParent() {

    return this.parent;
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    requireNotDisposed();
    if (parent == this.parent) {
      return;
    }
    UiPropagation oldPropagation = UiPropagation.NONE;
    if (this.parent != null) {
      oldPropagation = this.parent.getPropagation();
    }
    this.parent = parent;
    oldPropagation.updateParent(this);
  }

  @Override
  public boolean isVisible(BitMask mask) {

    if (mask == null) {
      if (this.visibleState != 0) {
        return false;
      }
      if (this.parent == null) {
        return isVisibleWithoutRoot();
      } else {
        return this.parent.isVisible(null);
      }
    }
    return mask.getFlag(this.visibleState);
  }

  /**
   * @return {@code true} if this is a root widget (e.g. UiMainWindow) that is visible without a parent, {@code false}
   *         otherwise.
   */
  protected boolean isVisibleWithoutRoot() {

    return false;
  }

  @Override
  public void setVisible(boolean visible, BitMask mask) {

    requireNotDisposed();
    doSetVisibleState(mask.setFlag(this.visibleState, visible));
  }

  /**
   * @param visible {@code true} to show this widget (in case its parent is also visible), {@code false} to hide this
   *        widget.
   */
  protected abstract void setVisibleNative(boolean visible);

  /**
   * @param widget the {@link AbstractUiNativeWidget}.
   * @return the internal {@link #isVisible(BitMask) visible state} of the given {@code widget}.
   */
  protected static final int doGetVisibleState(AbstractUiNativeWidget widget) {

    return widget.visibleState;
  }

  /**
   * @param state new value of {@link #doGetVisibleState(AbstractUiNativeWidget)}.
   */
  protected final void doSetVisibleState(int state) {

    if (state == this.visibleState) {
      return;
    }
    boolean oldNativeVisible = (this.visibleState == 0);
    this.visibleState = state;
    boolean nativeVisible = (this.visibleState == 0);
    if ((oldNativeVisible == nativeVisible)) {
      return;
    }
    setVisibleNative(nativeVisible);
    UiEvent event;
    if (nativeVisible) {
      event = new UiShowEvent(this);
    } else {
      event = new UiHideEvent(this);
    }
    fireEvent(event);
  }

  /**
   * @param widget the {@link AbstractUiNativeWidget}.
   * @param state new value of {@link #doGetVisibleState(AbstractUiNativeWidget)} of the given {@code widget}.
   */
  protected static final void doSetVisibleState(AbstractUiNativeWidget widget, int state) {

    widget.doSetVisibleState(state);
  }

  @Override
  public boolean isEnabled(BitMask mask) {

    if (mask == null) {
      if (this.enabledState != 0) {
        return false;
      }
      if (this.parent == null) {
        return false;
      } else {
        return this.parent.isEnabled(null);
      }
    }
    return mask.getFlag(this.enabledState);
  }

  @Override
  public void setEnabled(boolean enabled, BitMask mask) {

    requireNotDisposed();
    doSetEnabledState(mask.setFlag(this.enabledState, enabled));
  }

  /**
   * @param enabled the new {@link #isEnabled() enabled state}. Use {@code true} to enable and {@code false} to disable
   *        this widget.
   */
  protected abstract void setEnabledNative(boolean enabled);

  /**
   * @param widget the {@link AbstractUiNativeWidget}.
   * @return the internal {@link #isEnabled(BitMask) enabled state} of the given {@code widget}.
   */
  protected static final int doGetEnabledState(AbstractUiNativeWidget widget) {

    return widget.enabledState;
  }

  /**
   * @param state new value of {@link #doGetEnabledState(AbstractUiNativeWidget)}.
   */
  protected final void doSetEnabledState(int state) {

    if (state == this.enabledState) {
      return;
    }
    boolean oldNativeEnabled = (this.enabledState == 0);
    this.enabledState = state;
    boolean nativeEnabled = (this.enabledState == 0);
    if ((oldNativeEnabled == nativeEnabled)) {
      return;
    }
    setEnabledNative(nativeEnabled);
    UiEvent event;
    if (nativeEnabled) {
      event = new UiEnableEvent(this);
    } else {
      event = new UiDisableEvent(this);
    }
    fireEvent(event);
  }

  /**
   * @param widget the {@link AbstractUiNativeWidget}.
   * @param state new value of {@link #doGetEnabledState(AbstractUiNativeWidget)} of the given {@code widget}.
   */
  protected static final void doSetEnabledState(AbstractUiNativeWidget widget, int state) {

    widget.doSetEnabledState(state);
  }

  @Override
  public boolean isReadOnly() {

    Boolean readOnlyFixed = READ_ONLY_FIXED.getBoolean(this.readOnlyState);
    if (readOnlyFixed != null) {
      return readOnlyFixed.booleanValue();
    }
    return READ_ONLY.getFlag(this.readOnlyState);
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    int newReadOnly = READ_ONLY.setFlag(this.readOnlyState, readOnly);
    if (newReadOnly == this.readOnlyState) {
      return;
    }
    this.readOnlyState = newReadOnly;
    Boolean readOnlyFixed = READ_ONLY_FIXED.getBoolean(this.readOnlyState);
    if (readOnlyFixed == null) {
      setReadOnlyNative(readOnly);
      if (this instanceof UiComposite) {
        UiComposite<?> composite = (UiComposite<?>) this;
        int childCount = composite.getChildCount();
        for (int i = 0; i < childCount; i++) {
          UiWidget child = composite.getChild(i);
          child.setReadOnly(readOnly);
        }
      }
    }
  }

  /**
   * @param readOnly the new value of {@link #isReadOnly()}.
   */
  protected abstract void setReadOnlyNative(boolean readOnly);

  @Override
  public Boolean getReadOnlyFixed() {

    return READ_ONLY_FIXED.getBoolean(this.readOnlyState);
  }

  @Override
  public void setReadOnlyFixed(Boolean readOnlyFixed) {

    int newState = READ_ONLY_FIXED.setBoolean(this.readOnlyState, readOnlyFixed);
    if (newState == this.readOnlyState) {
      return;
    }
    boolean oldReadOnly = isReadOnly();
    this.readOnlyState = newState;
    boolean newReadOnly = isReadOnly();
    if (oldReadOnly != newReadOnly) {
      setReadOnlyNative(newReadOnly);
    }
  }

  @Override
  public boolean isValid() {

    return (this.validationFailure == null);
  }

  @Override
  public boolean validateDown(UiValidState state) {

    boolean valid = true;
    if (this instanceof UiComposite) {
      UiComposite<?> composite = (UiComposite<?>) this;
      int childCount = composite.getChildCount();
      for (int i = 0; i < childCount; i++) {
        UiWidget child = composite.getChild(i);
        if (!child.validateDown(state)) {
          valid = false;
        }
      }
      if (valid) {
        setValidationFailure(null);
      } else {
        setValidationFailure(this.context.getDefaultValidationFailure());
      }
    }
    if (this instanceof UiValidatableWidget) {
      valid = validate((UiValidatableWidget<?>) this, state);
    }
    return valid;
  }

  private <V> boolean validate(UiValidatableWidget<V> widget, UiValidState state) {

    V value = widget.getValue();
    Validator<? super V> validator = widget.getValidator();
    ValidationResult result = validator.validate(value, widget.getId());
    String error = result.getLocalizedMessage(this.context.getLocale());
    widget.setValidationFailure(error);
    if (state.isSetFocus() && (this instanceof UiInput)) {
      widget.setFocused();
      state.setFocussed();
    }
    boolean valid = (error == null);
    state.notify(valid);
    return valid;
  }

  @Override
  public final String getValidationFailure() {

    return this.validationFailure;
  }

  @Override
  public final void setValidationFailure(String validationFailure) {

    if (isEmpty(validationFailure)) {
      if (this.validationFailure == null) {
        return;
      }
      this.validationFailure = null;
    } else {
      if (validationFailure.equals(this.validationFailure)) {
        return;
      }
      this.validationFailure = validationFailure;
    }
    doSetValidationFailure(this.validationFailure);
  }

  /**
   * Called from {@link #setValidationFailure(String)} if the failure actually changed. Do not call manually.
   *
   * @param error the new {@link #getValidationFailure() validation failure}. Will be {@code null} if valid.
   */
  protected void doSetValidationFailure(String error) {

    if (error == null) {
      getStyles().remove(STYLE_INVALID);
    } else {
      getStyles().add(STYLE_INVALID);
    }
  }

  @Override
  public void addListener(UiEventListener listener, boolean weak) {

    ensureHandlers();
    super.addListener(listener, weak);
  }

  /**
   * Ensures that the event handlers (adapters) are {@link #registerHandlers() registered}.
   */
  protected void ensureHandlers() {

    if (!this.handlersRegistered) {
      registerHandlers();
      this.handlersRegistered = true;
    }
  }

  /**
   * Registers the according handlers to the underlying native widget. Never call manually, only via
   * {@link #ensureHandlers()}.
   */
  protected void registerHandlers() {

    if (this.handlersRegistered) {
      throw new IllegalStateException();
    }
  }

  /**
   * @return the {@link UiEventType} that was previously {@link #setProgrammaticEventType(UiEventType) set} as
   *         programmatic. ATTENTION: As a side-effect the value is reset to {@code null}.
   * @see io.github.mmm.ui.event.UiEvent#isProgrammatic()
   */
  protected UiEventType getProgrammaticEventType() {

    UiEventType result = this.programmaticEventType;
    this.programmaticEventType = null;
    return result;
  }

  /**
   * @param eventType the {@link UiEventType} to mark as {@link io.github.mmm.ui.event.UiEvent#isProgrammatic()
   *        programmatic}. If the next event is of this type, it will be set as
   *        {@link io.github.mmm.ui.event.UiEvent#isProgrammatic() programmatic}.
   */
  protected void setProgrammaticEventType(UiEventType eventType) {

    this.programmaticEventType = eventType;
  }

  @Override
  protected UiNativeWidget unwrap() {

    return this;
  }

  @Override
  public final boolean isDisposed() {

    return (this.enabledState == -1);
  }

  /**
   * Ensures that this widget is not {@link #isDisposed() disposed}.
   *
   * @throws IllegalStateException otherwise.
   */
  protected void requireNotDisposed() {

    if (isDisposed()) {
      throw new IllegalStateException(toString() + " is disposed");
    }
  }

  @Override
  public final void dispose() {

    if (isDisposed()) {
      return;
    }
    doDispose();
    this.enabledState = -1;
    this.visibleState = -1;
    this.parent = null;
  }

  /**
   * Called from {@link #dispose()}
   */
  protected void doDispose() {

  }

}
