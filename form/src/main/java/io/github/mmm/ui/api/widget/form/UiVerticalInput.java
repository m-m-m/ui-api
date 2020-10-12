/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiCompositeInput} that displays multiple {@link UiInput}s or other {@link UiRegularWidget regular widgets}
 * vertically. Instead of instantiating you typically want to create your own class extending
 * {@link UiCustomVerticalInput}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiVerticalInput<V> extends UiCompositeInput<V>, UiNativeWidget {

}
