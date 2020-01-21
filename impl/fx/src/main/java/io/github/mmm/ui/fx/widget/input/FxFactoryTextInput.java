/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.input.UiTextInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTextInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryTextInput implements UiSingleWidgetFactoryNative<UiTextInput> {

  @Override
  public Class<UiTextInput> getType() {

    return UiTextInput.class;
  }

  @Override
  public UiTextInput create(UiContext context) {

    return new FxTextInput(context);
  }

}
