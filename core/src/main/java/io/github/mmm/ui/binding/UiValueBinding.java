/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import io.github.mmm.ui.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.widget.value.UiBindableWidget;

/**
 * Interface for an external value binding for a {@link UiBindableWidget}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 * @see UiBindableWidget#initBinding(UiValueBinding)
 */
public interface UiValueBinding<V> extends AttributeWriteValueForUser<V> {

  /**
   * @param widget the {@link UiBindableWidget} that is {@link UiBindableWidget#initBinding(UiValueBinding) bound}.
   */
  default void setWidget(UiBindableWidget<V> widget) {

  }

}
