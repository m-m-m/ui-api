/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.value.UiBindableWidget;
import io.github.mmm.ui.widget.value.UiValidatableWidget;

/**
 * {@link UiDynamicComposite} with {@link UiValidatableWidget value and validation support}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiValuedComposite<C extends UiWidget, V>
    extends UiDynamicComposite<C>, UiFailureComposite<C>, UiBindableWidget<V> {

}
