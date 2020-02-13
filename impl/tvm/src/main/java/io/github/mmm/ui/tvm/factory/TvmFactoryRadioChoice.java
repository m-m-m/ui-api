/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.input.TvmRadioChoice;
import io.github.mmm.ui.widget.input.UiRadioChoice;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioChoice}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class TvmFactoryRadioChoice implements UiSingleWidgetFactoryNative<UiRadioChoice> {

  @Override
  public Class<UiRadioChoice> getType() {

    return UiRadioChoice.class;
  }

  @Override
  public UiRadioChoice create(UiContext context) {

    return new TvmRadioChoice(context);
  }

}
