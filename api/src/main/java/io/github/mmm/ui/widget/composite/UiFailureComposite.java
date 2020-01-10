/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.widget.UiFailureWidget;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.value.UiValidatableWidget;

/**
 * {@link UiValidatableWidget} that is a {@link UiComposite}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract interface UiFailureComposite<C extends UiWidget> extends UiFailureWidget, UiComposite<C> {

  @Override
  default boolean isValid() {

    return UiFailureWidget.super.isValid() && UiComposite.super.isValid();
  }

}
