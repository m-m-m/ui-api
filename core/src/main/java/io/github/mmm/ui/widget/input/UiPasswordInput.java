/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.validation.string.ValidatorPasswordConfirmation;

/**
 * {@link UiStringInput} for a password input.<br>
 * Example:
 *
 * <pre>
 * <input type="password" placeholder="placeholder" title="tooltip"/>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiPasswordInput extends UiStringInput, UiNativeWidget {

  /**
   * @return a new {@link UiPasswordInput} requiring a confirmation of the password.
   */
  default UiPasswordInput createConfirmationInput() {

    UiPasswordInput confirmation = of(getContext(), "Confirm " + getName(), AUTOCOMPLETE_NEW_PASSWORD);
    confirmation.setValidator(new ValidatorPasswordConfirmation(() -> getValue()));
    return confirmation;
  }

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_CURRENT_PASSWORD}.
   */
  static UiPasswordInput ofCurrent(UiContext context, String name) {

    return of(context, name, AUTOCOMPLETE_CURRENT_PASSWORD);
  }

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_NEW_PASSWORD}.
   */
  static UiPasswordInput ofNew(UiContext context, String name) {

    return of(context, name, AUTOCOMPLETE_NEW_PASSWORD);
  }

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_OFF}.
   */
  static UiPasswordInput ofOff(UiContext context, String name) {

    return of(context, name, AUTOCOMPLETE_OFF);
  }

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @param autocomplete the {@link #getAutocomplete() autocomplete}.
   * @return the new {@link UiPasswordInput}.
   */
  static UiPasswordInput of(UiContext context, String name, String autocomplete) {

    UiPasswordInput widget = context.create(UiPasswordInput.class);
    widget.setName(name);
    widget.setAutocomplete(autocomplete);
    return widget;
  }

}
