/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.value;

import io.github.mmm.ui.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.widget.attribute.UiWidgetWithValidationFailure;
import io.github.mmm.validation.Validator;

/**
 * {@link UiValuedWidget} with real {@link #getValidator() validation} support.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiValidatableWidget<V>
    extends UiValuedWidget<V>, UiWidgetWithValidationFailure, AttributeWriteValueForUser<V> {

  /**
   * Set both the {@link #getValue() value} and the {@link #getOriginalValue() original value} to the given argument.
   * Further, {@link #isModified() modified} is reset to {@code false}. In case the value type is mutable and you want
   * to set the {@link #getValue() value} to a clone or copy of the {@link #getOriginalValue() original value}, then
   * first call this method with the clone/copy and after that call {@link #setOriginalValue(Object)} with the
   * {@link #getOriginalValue() original value} that you have cloned.
   */
  @Override
  default void setValue(V value) {

    setValue(value, false);
  }

  /**
   * Like {@link #setValue(Object)} but will not change the {@link #getOriginalValue() original value} and will set
   * {@link #isModified() modified} to {@code true} (instead of {@code false}).<br>
   * This method is useful when you want to build a custom widget based on a
   * {@link io.github.mmm.ui.widget.input.UiInput} that is {@link #isReadOnly() read-only} and does not allow the
   * end-user to manually edit its value but via some other interaction such as a picker icon, a geographic map, or
   * something alike.
   *
   * @param value the new {@link #getValue() value}.
   */
  default void setValueForUser(V value) {

    setValue(value, true);
  }

  /**
   * @param value the new {@link #getValue() value}.
   * @param forUser - {@code true} for {@link #setValueForUser(Object)} and {@code false} for {@link #setValue(Object)}.
   */
  @Override
  void setValue(V value, boolean forUser);

  /**
   * @return the original value since it was last set via {@link #setOriginalValue(Object)} or most probably indirectly
   *         via {@link #setValue(Object)}. If this widget is {@link #isModified() modified}, {@link #getValue()} will
   *         return the current value as entered by the end-user while this method will still return the original value.
   *         <br>
   *         <b>ATTENTION:</b> The original value shall never be modified to avoid undesired side effects. Various
   *         features such as {@link #resetValue()} rely on this fact.
   * @see #resetValue()
   */
  V getOriginalValue();

  /**
   * @param originalValue the new value of {@link #getOriginalValue()}.
   */
  void setOriginalValue(V originalValue);

  /**
   * Rests the current {@link #getValue() value} to the {@link #getOriginalValue() original value}.
   */
  default void resetValue() {

    setValue(getOriginalValue());
  }

  /**
   * @return the {@link Validator} to validate the {@link #getValue() value} of this input.
   */
  Validator<? super V> getValidator();

  /**
   * @param validator the new {@link #getValidator() validator}. To add multiple validators, simply use
   *        {@link io.github.mmm.validation.ComposedValidator} or {@link Validator#append(Validator...)}.
   */
  void setValidator(Validator<? super V> validator);

}
