/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiVerticalPanel}.
 *
 * @since 1.0.0
 */
public class TvmFactoryVerticalPanel implements UiSingleWidgetFactoryNative<UiVerticalPanel> {

  @Override
  public Class<UiVerticalPanel> getWidgetInterface() {

    return UiVerticalPanel.class;
  }

  @Override
  public UiVerticalPanel create(UiContext context) {

    return new TvmVerticalPanel(context);
  }

}
