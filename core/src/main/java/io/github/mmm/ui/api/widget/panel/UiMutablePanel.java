/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiMutableComposite} for a generic panel that accepts any {@link UiRegularWidget} as {@link #getChild(int)
 * child}.
 *
 * @since 1.0.0
 */
public abstract interface UiMutablePanel extends UiMutableComposite<UiRegularWidget>, UiRegularWidget {

  /**
   * @param input the {@link UiInput} to add as {@link UiInput#getContainerWidget() container widget} (including its
   *        label).
   */
  default void addChild(UiInput<?> input) {

    addChild(input.getContainerWidget());
  }

}
