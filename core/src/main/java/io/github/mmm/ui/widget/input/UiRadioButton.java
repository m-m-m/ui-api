/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.UiToggleGroup;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.value.UiAbstractRadioButton;

/**
 * A regular {@link UiAbstractRadioButton radio-button widget}.<br>
 * Example:
 *
 * <pre>
 * <input type="radio" title="tooltip">Label</input>
 * </pre>
 *
 * In most cases you should use {@link UiRadioChoice} instead.
 *
 * @since 1.0.0
 */
public interface UiRadioButton extends UiAbstractRadioButton, UiInput<Boolean>, UiNativeWidget {

  /**
   * @param group the {@link UiToggleGroup} that combines multiple {@link UiRadioButton}s so that only one out of the
   *        group can be selected. For best UX you should typically use {@link UiRadioChoice} instead.
   */
  void setToggleGroup(UiToggleGroup group);

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiRadioButton}.
   */
  static UiRadioButton of(UiContext context, String name) {

    UiRadioButton widget = context.create(UiRadioButton.class);
    widget.setName(name);
    return widget;
  }

}
