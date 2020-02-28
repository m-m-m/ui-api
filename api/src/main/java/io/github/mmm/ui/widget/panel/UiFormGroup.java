/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.datatype.UiValidState;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithCollapse;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.validation.Validator;

/**
 * {@link UiAbstractCompositeInput} as {@link UiNativeWidget native widget} without {@link #getValue() value}.
 */
public interface UiFormGroup extends UiAbstractCompositeInput<UiInput<?>, Void>, UiWidgetWithCollapse, UiNativeWidget {

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
  default void validateUp(UiValidState state) {

    if (state.isValid()) {
      setValidationFailure(null);
    } else {
      setValidationFailure(getContext().getDefaultValidationFailure());
    }
    UiAbstractCompositeInput.super.validateUp(state);
  }

}
