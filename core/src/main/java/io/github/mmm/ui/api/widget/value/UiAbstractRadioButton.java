/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.value;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.widget.attribute.UiWidgetWithSelection;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiInput} for a radio-button (option).<br>
 * Example:
 *
 * <pre>
 * <input type="radio" title="tooltip">Label</input>
 * </pre>
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractRadioButton extends UiWidgetWithSelection, AttributeWriteText {

}
