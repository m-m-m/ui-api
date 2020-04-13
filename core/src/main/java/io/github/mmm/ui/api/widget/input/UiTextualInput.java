/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.attribute.AttributeWriteAutocomplete;
import io.github.mmm.ui.api.attribute.AttributeWritePlaceholder;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * Abstract {@link UiRegularWidget} for textual input.
 *
 * @param <V> type of the {@link #getValue() value}. Typically {@link String}.
 * @since 1.0.0
 */
public abstract interface UiTextualInput<V>
    extends UiInput<V>, AttributeWriteAutocomplete, AttributeWriteText, AttributeWritePlaceholder {

}
