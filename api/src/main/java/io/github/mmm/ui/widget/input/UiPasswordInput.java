/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.validation.string.ValidatorPasswordConfirmation;

/**
 * {@link UiTextualInput} for a password input.<br>
 * Example:
 *
 * <pre>
 * <input type="password" placeholder="placeholder" title="tooltip"/>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiPasswordInput extends UiTextualInput, UiNativeWidget {

  /**
   * @return a new {@link UiPasswordInput} requiring a confirmation of the password.
   */
  default UiPasswordInput createConfirmationInput() {

    UiPasswordInput confirmation = getContext().createPasswordInput(getName());
    confirmation.setValidator(new ValidatorPasswordConfirmation(() -> getValue()));
    return confirmation;
  }

}
