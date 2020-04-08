/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.value;

import io.github.mmm.ui.api.attribute.AttributeWriteValue;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiValuedWidget<V> extends UiWidget, AttributeWriteValue<V> {

  /**
   * @see UiValidatableWidget#getOriginalValue()
   * @see #isModified()
   */
  @Override
  void setValue(V value);

}
