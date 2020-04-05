/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.datatype;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Implementation of {@link UiSingleWidgetFactoryDatatype} for type {@link String}.
 *
 * @since 1.0.0
 */
public class UiFactoryDatatypeBoolean implements UiSingleWidgetFactoryDatatype<Boolean> {

  @Override
  public Class<Boolean> getType() {

    return Boolean.class;
  }

  @Override
  public UiInput<Boolean> create(UiContext context) {

    return context.create(UiCheckbox.class);
  }

}
