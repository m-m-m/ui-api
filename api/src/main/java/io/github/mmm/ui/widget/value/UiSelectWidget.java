/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.value;

import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiInput} providing an option that can be {@link #isSelected() selected} (e.g. checkbox, radio-button, etc.).
 *
 * @since 1.0.0
 */
public abstract interface UiSelectWidget extends UiValuedWidget<Boolean>, UiActiveWidget {

  /**
   * @return {@code true} if this option is selected (checked or active option), {@code false} otherwise.
   */
  default boolean isSelected() {

    return Boolean.TRUE.equals(getValue());
  }

  /**
   * @param selected the new value of {@link #isSelected()}.
   */
  default void setSelected(boolean selected) {

    setValue(Boolean.valueOf(selected));
  }

}
