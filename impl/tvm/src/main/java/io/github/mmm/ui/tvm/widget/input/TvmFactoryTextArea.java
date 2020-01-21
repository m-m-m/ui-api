/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.input.UiTextArea;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTextArea}.
 *
 * @since 1.0.0
 */
public class TvmFactoryTextArea implements UiSingleWidgetFactoryNative<UiTextArea> {

  @Override
  public Class<UiTextArea> getType() {

    return UiTextArea.class;
  }

  @Override
  public UiTextArea create(UiContext context) {

    return new TvmTextArea(context);
  }

}
