/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.value.UiBindableWidget;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;

/**
 * {@link UiMutableComposite} with {@link UiValidatableWidget value and validation support}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiValuedComposite<C extends UiWidget, V>
    extends UiMutableComposite<C>, UiFailureComposite<C>, UiBindableWidget<V> {

  @Override
  default boolean isValid() {

    return UiFailureComposite.super.isValid();
  }

  @Override
  default void reset() {

    UiMutableComposite.super.reset();
    UiBindableWidget.super.reset();
  }

}
