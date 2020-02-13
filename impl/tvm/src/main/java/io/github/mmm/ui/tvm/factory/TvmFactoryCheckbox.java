/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.input.TvmCheckbox;
import io.github.mmm.ui.widget.input.UiCheckbox;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiCheckbox}.
 *
 * @since 1.0.0
 */
public class TvmFactoryCheckbox implements UiSingleWidgetFactoryNative<UiCheckbox> {

  @Override
  public Class<UiCheckbox> getType() {

    return UiCheckbox.class;
  }

  @Override
  public UiCheckbox create(UiContext context) {

    return new TvmCheckbox(context);
  }

}
