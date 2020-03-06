/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import io.github.mmm.property.ReadableProperty;
import io.github.mmm.ui.widget.input.UiAbstractInput;

/**
 * Call-back interface receiving {@link UiAbstractInput input widgets} for {@link ReadableProperty properties}.
 *
 * @since 1.0.0
 * @see UiBinding#bindBean(io.github.mmm.bean.ReadableBean, UiBindingReceiver)
 */
public interface UiBindingReceiver {

  /**
   * @param <V> type of the {@link ReadableProperty#get() property value}.
   * @param property the {@link ReadableProperty} that is bound.
   * @param input the {@link UiAbstractInput} bound to the {@code property}.
   */
  <V> void add(ReadableProperty<V> property, UiAbstractInput<V> input);

}
