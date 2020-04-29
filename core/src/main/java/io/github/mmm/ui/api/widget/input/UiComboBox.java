/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractSingleChoice} for a <em>combo-box</em> that allows the end-user to expand a drop-down menu and
 * select the {@link #getValue() value} from a given list of {@link #getOptions() options}. However, the combo-box is
 * also and editable text input field that allows the user to enter the value manually including auto-completion from
 * the given {@link #getOptions() options} what is a valuable feature for accessibility and power-usage.<br>
 * (Simplified) example (press arrow down in the text field):
 *
 * <pre>
 * Fruits: <input
 * type="text" list="fruits" placeholder="Enter a fruit">
 * <datalist id="fruits">
 *   <option value="Apple"></option>
 *   <option value="Orange"></option>
 *   <option value="Peach"></option>
 * </datalist>
 * </pre>
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiComboBox<V> extends UiAbstractSingleChoice<V>, UiTextualInput<V>, UiNativeWidget {

  /**
   * @param <V> type of the {@link UiComboBox#getOptions() options}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiComboBox} instance.
   */
  static <V> UiComboBox<V> of(String name) {

    UiComboBox<V> widget = UiWidgetFactoryNative.get().create(UiComboBox.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

  /**
   * @param <V> type of the {@link Enum} {@link UiComboBox#getOptions() options}.
   * @param name the {@link #getName() name} (label).
   * @param enumType the {@link Class} reflecting an {@link Enum} defining the options.
   * @return the new {@link UiComboBox} instance.
   */
  static <V extends Enum<?>> UiComboBox<V> ofEnum(String name, Class<V> enumType) {

    UiComboBox<V> widget = of(name);
    widget.setOptions(enumType.getEnumConstants());
    return widget;
  }

  /**
   * @param <V> type of the {@link UiComboBox#getOptions() options}.
   * @param name the {@link #getName() name} (label).
   * @param options the {@link #getOptions() options}.
   * @return the new {@link UiComboBox} instance.
   */
  @SuppressWarnings("unchecked")
  static <V> UiComboBox<V> of(String name, V... options) {

    UiComboBox<V> widget = of(name);
    widget.setOptions(options);
    return widget;
  }

}
