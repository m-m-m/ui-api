/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.panel.UiFormPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiFormPanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryFormPanel implements UiSingleWidgetFactoryNative<UiFormPanel> {

  @Override
  public Class<UiFormPanel> getWidgetInterface() {

    return UiFormPanel.class;
  }

  @Override
  public UiFormPanel create(UiContext context) {

    return new FxFormPanel(context);
  }

}
