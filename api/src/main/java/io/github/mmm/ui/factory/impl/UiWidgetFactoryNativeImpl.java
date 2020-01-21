/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.impl;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.spi.factory.AbstractUiWidgetFactory;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Implementation of {@link UiWidgetFactoryNative}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class UiWidgetFactoryNativeImpl extends AbstractUiWidgetFactory<UiSingleWidgetFactoryNative>
    implements UiWidgetFactoryNative {

  /** The singleton instance. */
  public static final UiWidgetFactoryNativeImpl INSTANCE = new UiWidgetFactoryNativeImpl();

  /**
   * The constructor.
   */
  public UiWidgetFactoryNativeImpl() {

    super(UiSingleWidgetFactoryNative.class);
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required, UiContext context) {

    return createForType(widgetInterface, required, context);
  }

}
