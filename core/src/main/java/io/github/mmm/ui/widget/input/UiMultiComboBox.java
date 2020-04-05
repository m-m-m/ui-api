/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import java.util.List;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractMultiChoice} for a {@link UiComboBox} that allows choosing multiple options.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiMultiComboBox<V> extends UiAbstractMultiChoice<V>, UiTextualInput<List<V>>, UiNativeWidget {

}
