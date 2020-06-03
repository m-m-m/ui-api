/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.value;

import io.github.mmm.ui.api.attribute.AttributeWriteSelected;
import io.github.mmm.ui.api.widget.UiActiveWidget;

/**
 * {@link UiValuedWidget} with {@link Boolean} value that represents a {@link #isSelected() selection} (e.g. checkbox,
 * radio-button, etc.).
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetWithSelection
    extends UiValuedWidget<Boolean>, UiActiveWidget, AttributeWriteSelected {

  @Override
  default boolean isSelected() {

    return Boolean.TRUE.equals(getValue());
  }

  @Override
  default void setSelected(boolean selected) {

    setValue(Boolean.valueOf(selected));
  }

}
