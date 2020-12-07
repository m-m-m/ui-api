/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.event.EventSource;
import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.attribute.AttributeReadAttached;
import io.github.mmm.ui.api.attribute.AttributeReadValid;
import io.github.mmm.ui.api.attribute.AttributeWriteEnabled;
import io.github.mmm.ui.api.attribute.AttributeWriteId;
import io.github.mmm.ui.api.attribute.AttributeWriteReadOnly;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.attribute.AttributeWriteTooltip;
import io.github.mmm.ui.api.attribute.AttributeWriteVisible;
import io.github.mmm.ui.api.datatype.UiEnabledFlags;
import io.github.mmm.ui.api.datatype.UiStyles;
import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.datatype.UiVisibleFlags;
import io.github.mmm.ui.api.datatype.bitmask.BitMask;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.widget.composite.UiComposite;

/**
 * Interface for an adapter to a physical <em>widget</em> of the underlying native widget toolkit. Anything displayed on
 * the UI <br>
 * A widget is any object of the UI (user interface) and may be atomic or {@link UiComposite composite}. <br>
 * {@link UiNativeWidget Native widgets} can be {@link io.github.mmm.ui.api.factory.UiWidgetFactoryNative#create(Class)
 * created}. For convenience {@link UiNativeWidget native widgets} offer static {@code of} methods in their interface as
 * a "constructor". So e.g. to create a new label simply use {@code UiLabel#of(String) UiLabel.of("My Labeltext")}.<br>
 * If you want to make your UI code portable even for toolkits such as SWT, you need to make proper use of
 * {@link #dispose()} for all {@link UiWidget}s that are no longer needed what is generally a good idea. Further for
 * toolkits such as the web with HTML/CSS/JS (via TeaVM) there are some limitations for the client-side code. Check out
 * the documentation of TeaVM for further details.<br>
 * <b>ATTENTION:</b><br>
 * A {@link UiWidget} can only be used once in a client application. Even if you want to have the exact same button
 * twice on the screen you need to create two distinct instances. <br>
 * <br>
 * For advanced usage see also {@link UiCustomWidget}.
 *
 * @since 1.0.0
 */
public interface UiWidget extends EventSource<UiEvent, UiEventListener>, AttributeWriteId, AttributeReadValid,
    AttributeWriteVisible, AttributeWriteEnabled, AttributeWriteReadOnly, AttributeWriteTooltip, AttributeReadAttached {

  /**
   * @return the {@link UiStyles} of this widget. Use to add or remove custom styles.
   */
  UiStyles getStyles();

  /**
   * Recursively checks if this widget is enabled including all its {@link #getParent() parents}.
   *
   * @see #isEnabled(BitMask)
   */
  @Override
  default boolean isEnabled() {

    return isEnabled(null);
  }

  /**
   * @param mask the {@link BitMask} to check the enabled state of. See {@link UiEnabledFlags} for available options.
   *        May be {@code null} to check all modes including the {@link #getParent() parent} widget.
   * @return {@code true} if enabled, {@code false} if disabled (end-user cannot interact with this widget or its
   *         children).
   */
  boolean isEnabled(BitMask mask);

  @Override
  default void setEnabled(boolean enabled) {

    setEnabled(enabled, UiEnabledFlags.DEFAULT);
  }

  /**
   * @param enabled the new {@link #isEnabled() enabled state}. Use {@code true} to enable and {@code false} to disable
   *        this widget.
   * @param mask the {@link BitMask} to apply. See {@link UiEnabledFlags} for available options.
   * @see #setEnabled(boolean)
   */
  void setEnabled(boolean enabled, BitMask mask);

  /**
   * Recursively checks if this widget is visible including all its {@link #getParent() parents}.
   *
   * @see #isVisible(BitMask)
   */
  @Override
  default boolean isVisible() {

    return isVisible(null);
  }

  /**
   * @param mask the {@link BitMask} to check the visibility of. See {@link UiVisibleFlags} for available options. May
   *        be {@code null} to check all modes including the {@link #getParent() parent} widget.
   * @return {@code true} if visible, {@code false} if hidden.
   */
  boolean isVisible(BitMask mask);

  @Override
  default void setVisible(boolean visible) {

    setVisible(visible, UiVisibleFlags.DEFAULT);
  }

  /**
   * @param visible {@code true} to show this widget (in case its parent is also visible), {@code false} to hide this
   *        widget.
   * @param mask the {@link BitMask} to apply. See {@link UiVisibleFlags} for available options.
   * @see #isVisible()
   */
  void setVisible(boolean visible, BitMask mask);

  /**
   * @return {@code true} if this widget is read-only (value can not be edited by the user and is displayed as view only
   *         like a label), {@code false} otherwise.
   */
  @Override
  default boolean isReadOnly() {

    return true;
  }

  /**
   * Switches this widget between view (read-only {@code true}) and edit (read-only {@code false}) mode. This may also
   * have effects such that a {@link io.github.mmm.ui.api.widget.panel.UiButtonPanel} is showing a "Save" button only in
   * edit mode, while it shows an "Edit" button in read-only mode that switches to edit mode.<br>
   * A {@link io.github.mmm.ui.api.widget.composite.UiComposite} will propagate the read-only state to all its children
   * when this method is called. Please note that several widgets such as {@link UiLabel} are always read-only. In such
   * case this method will have no effect.
   *
   * @param readOnly the new value of {@link #isReadOnly()}.
   */
  @Override
  void setReadOnly(boolean readOnly);

  /**
   * @return the fixed {@link #isReadOnly() read-only mode} or {@code null} if not fixed.
   */
  Boolean getReadOnlyFixed();

  /**
   * Sets a fixed {@link #isReadOnly() read-only} mode. If not {@code null} the {@link #isReadOnly() read-only mode}
   * will be set to that value and further invocations of {@link #setReadOnly(boolean)} have no effect unless this
   * method is called again with a value of {@code null}. Use this method for a widget (e.g. a
   * {@link io.github.mmm.ui.api.widget.input.UiInput}) that should always be read-only. Unlike
   * {@link #setReadOnly(boolean)} this method is not recursive and will not propagate to child widgets.
   *
   * @param readOnlyFixed the new value of {@link #getReadOnlyFixed()}. May be {@code null} to reset.
   */
  void setReadOnlyFixed(Boolean readOnlyFixed);

  /**
   * @return {@code true} if this widget is {@link UiActiveWidget active} and currently has the focus (the cursor is
   *         placed in the widget e.g. a text input and it will receive keyboard events), {@code false} otherwise.
   */
  default boolean isFocused() {

    return false;
  }

  /**
   * This method sets the {@link #isFocused() focus} to this widget. In case of a
   * {@link io.github.mmm.ui.api.widget.composite.UiComposite} it will set the focus to the first child capable of
   * taking the focus.<br>
   * <b>NOTE:</b><br>
   * You can only set the focus. To actually remove it, you need to set it in a different widget.
   *
   * @return {@code true} if the focus has been set successfully, {@code false} otherwise. You can normally ignore the
   *         result. It is only relevant for composite widgets such as panels, that delegate the call recursively and
   *         may not contain any child that can take the focus.
   */
  default boolean setFocused() {

    return false;
  }

  /**
   * A {@link io.github.mmm.ui.api.widget.composite.UiComposite} is only valid if all its children are valid (recursive
   * check). An atomic widget that does not implement {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget} will
   * always return {@code true} here.
   *
   * @see io.github.mmm.ui.api.widget.value.UiValidatableWidget
   * @see #validate()
   */
  @Override
  default boolean isValid() {

    return true;
  }

  /**
   * Triggers a validation of this widget (including all potential
   * {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int) children} and propagation to
   * {@link #getParent() parent}s). This will update the {@link #isValid() valid state} and
   * {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#getValidationFailure() failure message} of all
   * involved widgets. For an immutable widget (e.g. a {@link UiLabel}) this method will have no effect and immediately
   * returns {@code true}.
   *
   * @return the new {@link #isValid() valid status} as result of this validation. In other words {@code true} if this
   *         widget and all its potential {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int)
   *         children} have been successfully validated, {@code false} otherwise.
   * @see io.github.mmm.ui.api.widget.value.UiValidatableWidget
   * @see #isValid()
   * @see #validate(UiValidState)
   * @see #validateDown(UiValidState)
   * @see #validateUp(UiValidState)
   */
  default boolean validate() {

    return validate(new UiValidState());
  }

  /**
   * Triggers a validation of this widget (including all potential
   * {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int) children} and propagation to
   * {@link #getParent() parent}s). This will update the {@link #isValid() valid state} and
   * {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#getValidationFailure() failure message} of all
   * involved widgets. For an immutable widget (e.g. a {@link UiLabel}) this method will have no effect and immediately
   * returns {@code true}.
   *
   * @param updateFocus - {@code true} to put the focus in the first invalid field, {@code false} otherwise.
   * @return the new {@link #isValid() valid status} as result of this validation. In other words {@code true} if this
   *         widget and all its potential {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int)
   *         children} have been successfully validated, {@code false} otherwise.
   */
  default boolean validate(boolean updateFocus) {

    UiValidState state = new UiValidState();
    if (!updateFocus) {
      state.setFocussed();
    }
    return validate(state);
  }

  /**
   * Triggers a validation of this widget (including all potential
   * {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int) children} and propagation to
   * {@link #getParent() parent}s). This will update the {@link #isValid() valid state} and
   * {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#getValidationFailure() failure message} of all
   * involved widgets. For an immutable widget (e.g. a {@link UiLabel}) this method will have no effect and immediately
   * returns {@code true}.
   *
   * @param state the {@link UiValidState}.
   * @return the new {@link #isValid() valid status} as result of this validation. In other words {@code true} if this
   *         widget and all its potential {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int)
   *         children} have been successfully validated, {@code false} otherwise.
   */
  default boolean validate(UiValidState state) {

    validateDown(state);
    boolean valid = state.isValid();
    UiComposite<?> parent = getParent();
    if (parent != null) {
      parent.validateUp(state);
    }
    return valid;
  }

  /**
   * Propagates the new {@link UiValidState} to {@link #getParent() parent} (and recursively to ancestors). This allows
   * tabs and composites that can collapse or hide their children to indicate validation failures (e.g. with an error
   * icon) so the end-user is able to find invalid data even in hidden children and can correct the data.
   *
   * @param state the new {@link UiValidState}.
   * @see #validate()
   */
  default void validateUp(UiValidState state) {

    UiComposite<?> parent = getParent();
    if (parent != null) {
      parent.validateUp(state);
    }
  }

  /**
   * Performs {@link #validate() validation} without {@link #validateUp(UiValidState) upwards propagation}.
   *
   * @param state the new {@link UiValidState}.
   * @return the new {@link #isValid() valid status} as result of this validation. In other words {@code true} if this
   *         widget and all its potential {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int)
   *         children} have been successfully validated, {@code false} otherwise. Can differ from
   *         {@link UiValidState#isValid()} if the subtree of this widget is valid but other widgets have been validated
   *         before.
   * @see #validate()
   */
  boolean validateDown(UiValidState state);

  /**
   * @return {@code true} if the value has been <em>modified</em> by the end-user via the UI since it has been
   *         {@link io.github.mmm.ui.api.widget.value.UiValuedWidget#setValue(Object) set programmatically},
   *         {@code false} otherwise. A modified widget is also called <em>dirty</em>. A {@link UiComposite} is modified
   *         if one of its {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int) children} are
   *         modified. An immutable widget (e.g. a {@link UiLabel}) will always return {@code false} here.<br>
   *         <b>ATTENTION:</b> If the end-user changes value of this widget via the UI then changes it back to its
   *         {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#getOriginalValue() original value} it may
   *         still remain {@link #isModified() modified}.
   */
  default boolean isModified() {

    return (getModificationTimestamp() > 0);
  }

  /**
   * @return the timestamp of the last change to this widget. Will be {@code -1} if it not {@link #isModified()
   *         modified}.
   */
  default long getModificationTimestamp() {

    return -1;
  }

  /**
   * @return the parent of this widget or {@code null} if not attached to the UI or if this is a root widget (e.g. the
   *         main window).
   */
  UiComposite<?> getParent();

  /**
   * @param <W> the requested {@link UiWidget} type.
   * @return this instance casted to the expected type.
   */
  @SuppressWarnings("unchecked")
  default <W extends UiWidget> W cast() {

    return (W) this;
  }

  /**
   * Resets this widget recursively including its potential
   * {@link io.github.mmm.ui.api.widget.composite.UiComposite#getChild(int) children} to its original state.
   * {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget}s will retain their
   * {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#getOriginalValue() original value}. Further,
   * {@link #isModified() modified flags} are reset so all involved widgets will not be {@link #isModified() modified}
   * after calling this method.
   */
  default void reset() {

  }

  /**
   * This method disposes this widget. It is detached from the UI and resources are deallocated. A disposed widget can
   * not be used or displayed anymore.
   */
  void dispose();

  /**
   * @return {@code true} if this widget has already been {@link #dispose() disposed} and became useless, {@code false}
   *         otherwise.
   */
  boolean isDisposed();

  /**
   * @param <W> type of the {@link UiWidget}.
   * @param widget the {@link UiWidget} to initialize with the given {@code text}.
   * @param text the {@link AttributeWriteText#getText() text} to {@link AttributeWriteText#setText(String) set}. May be
   *        {@code null} in which case this method has no effect.
   */
  static <W extends UiWidget & AttributeWriteText> void initText(W widget, String text) {

    initText(widget, text, null);
  }

  /**
   * @param <W> type of the {@link UiWidget}.
   * @param widget the {@link UiWidget} to initialize with the given {@code text}.
   * @param text the {@link AttributeWriteText#getText() text} to {@link AttributeWriteText#setText(String) set}. May be
   *        {@code null} in which case this method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static <W extends UiWidget & AttributeWriteText> void initText(W widget, String text, Object context) {

    if (text != null) {
      String l10n = UiLocalizer.get().localize(text, context);
      widget.setText(l10n);
    }
  }

}
