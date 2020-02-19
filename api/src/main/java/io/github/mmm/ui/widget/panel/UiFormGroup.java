/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithCollapse;
import io.github.mmm.validation.Validator;

/**
 * {@link UiAbstractFormGroup} as {@link UiNativeWidget native widget} without {@link #getValue() value}.
 */
public interface UiFormGroup extends UiAbstractFormGroup<Void>, UiWidgetWithCollapse, UiNativeWidget {

  @Override
  default Validator<? super Void> getValidator() {

    return null;
  }

  @Override
  default void setValidator(Validator<? super Void> validator) {

  }

  @Override
  default void setValue(Void value) {

  }

  @Override
  default void setValueForUser(Void value) {

  }

  @Override
  default Void getOriginalValue() {

    return null;
  }

  @Override
  default void setOriginalValue(Void originalValue) {

  }

  @Override
  default Void getValue() {

    return null;
  }

  @Override
  default void validateUp(boolean valid) {

    if (valid) {
      setValidationFailure(null);
    } else {
      setValidationFailure(getContext().getDefaultValidationFailure());
    }
    UiAbstractFormGroup.super.validateUp(valid);
  }

}
