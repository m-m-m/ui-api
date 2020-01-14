/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.input.UiRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryRadioButton implements UiSingleWidgetFactoryNative<UiRadioButton> {

  @Override
  public Class<UiRadioButton> getWidgetInterface() {

    return UiRadioButton.class;
  }

  @Override
  public UiRadioButton create(UiContext context) {

    return new FxRadioButton(context);
  }

}
