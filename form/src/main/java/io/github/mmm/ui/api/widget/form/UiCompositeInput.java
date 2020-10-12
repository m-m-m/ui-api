/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.value.UiBindableWidget;

/**
 * {@link UiInput} that acts as {@link UiComposite} to contain multiple {@link UiInput}s or other {@link UiRegularWidget
 * regular widgets}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiCompositeInput<V>
    extends UiAbstractCompositeInput<UiRegularWidget, V>, UiInput<V>, UiBindableWidget<V> {

}
