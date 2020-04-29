/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiCompositeInput} that represents multiple {@link UiInput}s (or other
 * {@link io.github.mmm.ui.api.widget.UiRegularWidget regular widgets}) as a single row with a {@link #getNameWidget()
 * label}. This allows to combine multiple inputs that are closely related into a single {@link UiInput}. Good example
 * are a range input with a start (minimum) and end end (maximum) value or a new password input that should be confirmed
 * in a second password input.
 *
 * @since 1.0.0
 */
public interface UiInputColumns extends UiCompositeInput, UiNativeWidget {

}
