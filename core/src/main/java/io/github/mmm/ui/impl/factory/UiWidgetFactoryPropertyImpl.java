/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.factory;

import io.github.mmm.ui.api.factory.AbstractUiWidgetFactory;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty;
import io.github.mmm.ui.api.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.api.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.value.ReadableValue;

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

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  protected UiSingleWidgetFactoryProperty<?> merge(UiSingleWidgetFactoryProperty<?> existingFactory,
      UiSingleWidgetFactoryProperty<?> newFactory) {

    UiSingleWidgetFactoryPropertyComposed composedFactory = UiSingleWidgetFactoryPropertyComposed.of(existingFactory);
    composedFactory.add(newFactory);
    return composedFactory;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V> UiInput<V> create(ReadableValue<V> property, boolean required) {

    Class<? extends ReadableValue<V>> propertyType = (Class<? extends ReadableValue<V>>) property.getClass();
    UiSingleWidgetFactoryProperty<V> factory = (UiSingleWidgetFactoryProperty<V>) getForType(propertyType);
    UiInput<V> input = null;
    if (factory != null) {
      input = factory.create(property);
    }
    if (input == null) {
      input = UiWidgetFactoryDatatype.get().create(property.getValueClass(), required);
    }
    return input;
  }

}
