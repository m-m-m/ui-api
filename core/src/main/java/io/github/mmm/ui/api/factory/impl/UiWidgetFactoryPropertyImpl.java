/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory.impl;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty;
import io.github.mmm.ui.api.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.spi.factory.AbstractUiWidgetFactory;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Implementation of {@link UiWidgetFactoryProperty}.
 *
 * @since 1.0.0
 */
public class UiWidgetFactoryPropertyImpl extends AbstractUiWidgetFactory<UiSingleWidgetFactoryProperty<?>>
    implements UiWidgetFactoryProperty {

  /** The singleton instance. */
  public static final UiWidgetFactoryPropertyImpl INSTANCE = new UiWidgetFactoryPropertyImpl();

  /**
   * The constructor.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public UiWidgetFactoryPropertyImpl() {

    super((Class) UiSingleWidgetFactoryProperty.class);
  }

  @Override
  public <V> UiInput<V> create(Class<? extends ReadableTypedValue<V>> propertyType, boolean required,
      UiContext context) {

    return createForType(propertyType, required, context);
  }

}
