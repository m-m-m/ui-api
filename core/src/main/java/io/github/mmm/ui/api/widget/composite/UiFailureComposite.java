/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.attribute.AttributeWriteValidationFailure;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;

/**
 * {@link UiValidatableWidget} that is a {@link UiComposite}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract interface UiFailureComposite<C extends UiWidget> extends AttributeWriteValidationFailure, UiComposite<C> {

  @Override
  default boolean isValid() {

    return AttributeWriteValidationFailure.super.isValid() && UiComposite.super.isValid();
  }

}
