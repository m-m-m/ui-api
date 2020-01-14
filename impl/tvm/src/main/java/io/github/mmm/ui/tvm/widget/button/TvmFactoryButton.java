/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.button;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.button.UiButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiButton}.
 *
 * @since 1.0.0
 */
public class TvmFactoryButton implements UiSingleWidgetFactoryNative<UiButton> {

  @Override
  public Class<UiButton> getWidgetInterface() {

    return UiButton.class;
  }

  @Override
  public UiButton create(UiContext context) {

    return new TvmButton(context);
  }

}
