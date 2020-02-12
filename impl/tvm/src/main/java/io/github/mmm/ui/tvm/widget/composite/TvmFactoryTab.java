/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.composite.UiTab;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTab}.
 *
 * @since 1.0.0
 */
public class TvmFactoryTab implements UiSingleWidgetFactoryNative<UiTab> {

  @Override
  public Class<UiTab> getType() {

    return UiTab.class;
  }

  @Override
  public UiTab create(UiContext context) {

    return new TvmTab(context);
  }

}
