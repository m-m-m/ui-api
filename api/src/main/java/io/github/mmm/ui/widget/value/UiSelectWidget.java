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
  boolean isSelected();

  /**
   * @param selected the new value of {@link #isSelected()}.
   */
  void setSelected(boolean selected);

  @Override
  default Boolean getValue() {

    return Boolean.valueOf(isSelected());
  }

  @Override
  default void setValue(Boolean value) {

    setSelected(Boolean.TRUE.equals(value));
  }

}
