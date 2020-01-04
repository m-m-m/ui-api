/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import java.util.List;

/**
 * {@link UiAbstractChoice} for a multiple choice out of a pre-define {@link List} of {@link #getOptions() options}.
 *
 * @param <V> type of an {@link #getOptions() option}.
 * @since 1.0.0
 */
public abstract interface UiAbstractMultiChoice<V> extends UiAbstractChoice<V, List<V>> {

}
