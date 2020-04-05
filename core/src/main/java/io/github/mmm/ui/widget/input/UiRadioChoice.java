/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractSingleChoice} to select a value from a group of {@link UiRadioButton}s. You should only use this
 * input widget when you have a small number of {@link #getOptions() options} with rather short text (2-5 options not
 * longer than 10 characters each). Otherwise you should use alternatives such as {@link UiComboBox} for better UX. <br>
 * Example:
 *
 * <pre>
 * Matrimony: <input
 * type="radio" name="status"> single</input> <input
 * type="radio" name="status"> married</input> <input
 * type="radio" name="status"> divorced</input>
 * </pre>
 *
 * <br>
 * <b>ATTENTION:</b> Initially no option is selected and the {@link #getValue() value} may be {@code null}. You can set
 * a reasonable initial value as default. However, it is often better to force the end-user to make his choice. As
 * {@code null} is not a good choice in most cases you typically want to
 * {@link #setValidator(io.github.mmm.validation.Validator) set a validator} that is
 * {@link io.github.mmm.validation.Validator#isMandatory() mandatory} then. <br>
 * <b>NOTICE:</b> Depending on the implementation you may receive a focus loss event immediately followed by a focus
 * gain event in case the end-user changes focus from one option to another. However, other implementations may not send
 * events in this case.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiRadioChoice<V> extends UiAbstractSingleChoice<V>, UiNativeWidget {

  /**
   * @param <V> type of the {@link UiRadioChoice#getOptions() options}.
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @param enumType the {@link Class} reflecting an {@link Enum} defining the options.
   * @return the new widget instance.
   */
  static <V extends Enum<?>> UiRadioChoice<V> ofEnum(UiContext context, String name, Class<V> enumType) {

    UiRadioChoice<V> widget = context.create(UiRadioChoice.class);
    widget.setName(name);
    widget.setOptions(enumType.getEnumConstants());
    return widget;
  }

  /**
   * @param <V> type of the {@link UiRadioChoice#getOptions() options}.
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @param options the {@link #getOptions() options}.
   * @return the new widget instance.
   */
  @SuppressWarnings("unchecked")
  static <V> UiRadioChoice<V> of(UiContext context, String name, V... options) {

    UiRadioChoice<V> widget = context.create(UiRadioChoice.class);
    widget.setName(name);
    widget.setOptions(options);
    return widget;
  }

}
