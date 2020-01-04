/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.value.UiAbstractRadioButton;

/**
 * A regular {@link UiAbstractRadioButton radio-button widget}.<br>
 * Example:
 *
 * <pre>
 * <input type="radio" title="tooltip">Label</input>
 * </pre>
 * 
 * In most cases you should use {@link UiRadioButtonChoice} instead.
 *
 * @since 1.0.0
 */
public interface UiRadioButton extends UiAbstractRadioButton, UiInput<Boolean>, UiNativeWidget {

}
