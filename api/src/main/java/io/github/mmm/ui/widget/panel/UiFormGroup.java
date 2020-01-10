/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import io.github.mmm.ui.widget.composite.UiFailureComposite;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiDynamicComposite} for a {@link #getName() named} sub-group in a {@link UiFormPanel form} of {@link UiInput}s
 * as {@link #getChild(int) children} shown vertically from the top to the bottom.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiFormGroup<V>
    extends UiDynamicComposite<UiInput<?>>, UiFailureComposite<UiInput<?>>, UiAbstractInput<V>, UiNativeWidget {

}
