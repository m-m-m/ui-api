/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.attribute.AttributeWritePrefix;
import io.github.mmm.ui.api.attribute.AttributeWriteSuffix;
import io.github.mmm.ui.api.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.api.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.value.UiValuedWidget;
import io.github.mmm.value.ReadableTypedValue;

/**
 * {@link UiValuedWidget} for an {@link UiRegularWidget regular} input field.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiInput<V>
    extends UiAbstractInput<V>, UiRegularWidget, AttributeWritePrefix, AttributeWriteSuffix {

  /**
   * @return {@code true} if the {@link #getNameWidget() name widget} has already been created, {@code false} otherwise.
   *         Helpful to avoid unintended lazy initialization.
   */
  boolean hasNameWidget();

  /**
   * @return the {@link UiLabel} of this input. May be lazily created on the first call of this method to avoid
   *         unnecessary overhead (e.g. if a {@link UiInput} is used for inline editing).
   */
  UiLabel getNameWidget();

  /**
   * @return {@code true} if the {@link #getContainerWidget() container widget} has already been created, {@code false}
   *         otherwise. Helpful to avoid unintended lazy initialization.
   */
  boolean hasContainerWidget();

  /**
   * @return the {@link UiRegularWidget} containing both the {@link #getNameWidget() name widget} and the actual input
   *         widget. Will be lazily created on the first call of this method.
   */
  UiRegularWidget getContainerWidget();

  /**
   * @param <V> type of the {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype the {@link Class} reflecting the
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @return the {@link UiInput} for the given {@code datatype}.
   */
  static <V> UiInput<V> of(Class<V> datatype) {

    return of(datatype, true);
  }

  /**
   * @param <V> type of the {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype the {@link Class} reflecting the
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code datatype}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  static <V> UiInput<V> of(Class<V> datatype, boolean required) {

    return UiWidgetFactoryDatatype.get().create(datatype, required);
  }

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @return the {@link UiInput} for the given {@code property}.
   */
  static <V> UiInput<V> of(ReadableTypedValue<V> property) {

    return of(property, true);
  }

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryProperty} or
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype} has to be registered for the given
   *        {@code property}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  @SuppressWarnings("unchecked")
  static <V> UiInput<V> of(ReadableTypedValue<V> property, boolean required) {

    Class<? extends ReadableTypedValue<V>> propertyType = (Class<? extends ReadableTypedValue<V>>) property.getClass();
    UiInput<V> input = UiWidgetFactoryProperty.get().create(propertyType, false);
    if (input == null) {
      input = of(property.getValueClass(), required);
    }
    return input;
  }

}
