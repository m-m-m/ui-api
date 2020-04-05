/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.value;

import io.github.mmm.ui.binding.UiValueBinding;

/**
 * {@link UiValidatableWidget} with external {@link UiValueBinding}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiBindableWidget<V> extends UiValidatableWidget<V> {

  /**
   * Initializes the value binding.
   *
   * @param binding the {@link UiValueBinding} defining how to read and write the value.
   */
  void initBinding(UiValueBinding<V> binding);

}
