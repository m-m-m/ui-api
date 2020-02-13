/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.panel.TvmTabPanel;
import io.github.mmm.ui.widget.panel.UiTabPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTabPanel}.
 *
 * @since 1.0.0
 */
public class TvmFactoryTabPanel implements UiSingleWidgetFactoryNative<UiTabPanel> {

  @Override
  public Class<UiTabPanel> getType() {

    return UiTabPanel.class;
  }

  @Override
  public UiTabPanel create(UiContext context) {

    return new TvmTabPanel(context);
  }

}
