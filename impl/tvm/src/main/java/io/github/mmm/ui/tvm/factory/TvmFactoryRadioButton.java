/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.input.TvmRadioButton;
import io.github.mmm.ui.widget.input.UiRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioButton}.
 *
 * @since 1.0.0
 */
public class TvmFactoryRadioButton implements UiSingleWidgetFactoryNative<UiRadioButton> {

  @Override
  public Class<UiRadioButton> getType() {

    return UiRadioButton.class;
  }

  @Override
  public UiRadioButton create(UiContext context) {

    return new TvmRadioButton(context);
  }

}
