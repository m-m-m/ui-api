/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory.impl;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryProperty;
import io.github.mmm.ui.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.spi.factory.AbstractUiWidgetFactory;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Implementation of {@link UiWidgetFactoryProperty}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class UiWidgetFactoryPropertyImpl extends AbstractUiWidgetFactory<UiSingleWidgetFactoryProperty>
    implements UiWidgetFactoryProperty {

  /** The singleton instance. */
  public static final UiWidgetFactoryPropertyImpl INSTANCE = new UiWidgetFactoryPropertyImpl();

  /**
   * The constructor.
   */
  public UiWidgetFactoryPropertyImpl() {

    super(UiSingleWidgetFactoryProperty.class);
  }

  @Override
  public <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> propertyType, boolean required, UiContext context) {

    return createForType(propertyType, required, context);
  }

}
