/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.panel.TvmButtonPanel;
import io.github.mmm.ui.widget.panel.UiButtonPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiButtonPanel}.
 *
 * @since 1.0.0
 */
public class TvmFactoryButtonPanel implements UiSingleWidgetFactoryNative<UiButtonPanel> {

  @Override
  public Class<UiButtonPanel> getType() {

    return UiButtonPanel.class;
  }

  @Override
  public UiButtonPanel create(UiContext context) {

    return new TvmButtonPanel(context);
  }

}
