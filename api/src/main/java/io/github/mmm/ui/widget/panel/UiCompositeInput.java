/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiComposite;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiInput} that acts as {@link UiComposite} to contain multiple {@link UiInput}s or other {@link UiRegularWidget
 * regular widgets}.
 *
 * @since 1.0.0
 */
public abstract interface UiCompositeInput extends UiAbstractCompositeInput<UiRegularWidget, Void>, UiInput<Void> {

}
