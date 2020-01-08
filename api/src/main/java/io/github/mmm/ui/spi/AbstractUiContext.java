/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Abstract base implementation of {@link UiContext}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiContext implements UiContext {

  private final UiWidgetFactoryNative nativeFactory;

  private final UiWidgetFactoryDatatype datatypeFactory;

  private final UiWidgetFactoryProperty propertyFactory;

  /**
   * The constructor.
   */
  public AbstractUiContext() {

    this(UiWidgetFactoryNative.get(), UiWidgetFactoryDatatype.get(), UiWidgetFactoryProperty.get());
  }

  /**
   * The constructor.
   *
   * @param nativeFactory the {@link UiWidgetFactoryNative} instance.
   * @param datatypeFactory the {@link UiWidgetFactoryDatatype} instance.
   * @param propertyFactory the {@link UiWidgetFactoryProperty} instance.
   */
  public AbstractUiContext(UiWidgetFactoryNative nativeFactory, UiWidgetFactoryDatatype datatypeFactory,
      UiWidgetFactoryProperty propertyFactory) {

    super();
    this.nativeFactory = nativeFactory;
    this.datatypeFactory = datatypeFactory;
    this.propertyFactory = propertyFactory;
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required) {

    return this.nativeFactory.create(widgetInterface, required, this);
  }

  @Override
  public <V> UiInput<V> createInput(Class<V> datatype, boolean required) {

    return this.datatypeFactory.create(datatype, required, this);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V> UiInput<V> createInput(ReadableTypedValue<V> property, boolean required) {

    Class<? extends ReadableTypedValue<V>> propertyType = (Class<? extends ReadableTypedValue<V>>) property.getClass();
    UiInput<V> input = this.propertyFactory.create(propertyType, false, this);
    if (input == null) {
      input = createInput(property.getValueClass(), required);
    }
    return input;
  }

}
