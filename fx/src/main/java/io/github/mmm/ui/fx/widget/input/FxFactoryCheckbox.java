/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.input.UiCheckbox;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryCheckbox implements UiSingleWidgetFactoryNative<UiCheckbox> {

  @Override
  public Class<UiCheckbox> getWidgetInterface() {

    return UiCheckbox.class;
  }

  @Override
  public UiCheckbox create(UiContext context) {

    return new FxCheckbox(context);
  }

}
