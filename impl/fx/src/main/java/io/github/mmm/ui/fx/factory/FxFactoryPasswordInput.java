/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.input.FxPasswordInput;
import io.github.mmm.ui.widget.input.UiPasswordInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiPasswordInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryPasswordInput implements UiSingleWidgetFactoryNative<UiPasswordInput> {

  @Override
  public Class<UiPasswordInput> getType() {

    return UiPasswordInput.class;
  }

  @Override
  public UiPasswordInput create(UiContext context) {

    return new FxPasswordInput(context);
  }

}
