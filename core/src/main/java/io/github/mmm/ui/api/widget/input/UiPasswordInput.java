/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
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

    UiPasswordInput confirmation = of("Confirm " + getName(), AUTOCOMPLETE_NEW_PASSWORD);
    confirmation.setValidator(new ValidatorPasswordConfirmation(() -> getValue()));
    return confirmation;
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_CURRENT_PASSWORD}.
   */
  static UiPasswordInput ofCurrent(String name) {

    return of(name, AUTOCOMPLETE_CURRENT_PASSWORD);
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_NEW_PASSWORD}.
   */
  static UiPasswordInput ofNew(String name) {

    return of(name, AUTOCOMPLETE_NEW_PASSWORD);
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiPasswordInput} with {@link #AUTOCOMPLETE_OFF}.
   */
  static UiPasswordInput ofOff(String name) {

    return of(name, AUTOCOMPLETE_OFF);
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @param autocomplete the {@link #getAutocomplete() autocomplete}.
   * @return the new {@link UiPasswordInput}.
   */
  static UiPasswordInput of(String name, String autocomplete) {

    UiPasswordInput widget = UiWidgetFactoryNative.get().create(UiPasswordInput.class);
    if (name != null) {
      widget.setName(name);
    }
    if (autocomplete != null) {
      widget.setAutocomplete(autocomplete);
    }
    return widget;
  }

}
