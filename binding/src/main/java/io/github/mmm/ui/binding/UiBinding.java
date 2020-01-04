/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import io.github.mmm.property.WritableProperty;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.widget.input.UiInput;

/**
 *
 */
public final class UiBinding {

  private UiBinding() {

  }

  /**
   * @param <V> type of the value.
   * @param property the {@link WritableProperty} to bind.
   * @param input the {@link UiInput} to bind.
   */
  public static <V> void bind(WritableProperty<V> property, UiInput<V> input) {

    input.setValidator(property.getMetadata().getValidator());
    input.setFieldLabel(property.getName());
    input.addListener((e) -> {
      if (e.getType() == UiValueChangeEvent.TYPE) {
        V value = input.getValue();
        property.set(value);
      }
    });
    property.addListener((e) -> {
      if (!e.isChange()) {
        V value = property.get();
        input.setValue(value);
      }
    }, true);
  }

}
