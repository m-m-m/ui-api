/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import java.util.Locale;
import java.util.ResourceBundle;

import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.impl.UiContextProvider;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Context and central API of the user-interface (UI). UIs consist of many smaller components that should be easy to
 * create. Dependency injection (DI) would make the programming model more complex. In such cases you need to pass
 * required components manually. This context is the central container to make this easy and maintainable. It acts as
 * factory for other {@link UiWidget}s as well as contextual state for the UI.
 *
 * @since 1.0.0
 */
public interface UiContext {

  /**
   * @return the {@link Locale} of the current user.
   */
  Locale getLocale();

  /**
   * @param key the {@link ResourceBundle#getString(String) key}.
   * @return the localized text.
   */
  String localize(String key);

  /**
   * @return the {@link UiDispatcher}.
   */
  UiDispatcher getDispatcher();

  /**
   * @return a new {@link UiToggleGroup} instance.
   */
  UiToggleGroup createToggleGroup();

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @return the new {@link UiNativeWidget}.
   */
  default <W extends UiNativeWidget> W create(Class<W> widgetInterface) {

    return create(widgetInterface, true);
  }

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @param required {@code true} if a {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative} has to be
   *        registered for the given {@code widgetInterface}, {@code false} otherwise.
   * @return the new {@link UiNativeWidget}. May be {@code null} if {@code required} is {@code false}.
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required);

  /**
   * @param <V> type of the {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype the {@link Class} reflecting the
   *        {@link io.github.mmm.ui.api.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @return the {@link UiInput} for the given {@code datatype}.
   */
  default <V> UiInput<V> createInput(Class<V> datatype) {

    return createInput(datatype, true);
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
  <V> UiInput<V> createInput(Class<V> datatype, boolean required);

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @return the {@link UiInput} for the given {@code property}.
   */
  default <V> UiInput<V> createInput(ReadableTypedValue<V> property) {

    return createInput(property, true);
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
  <V> UiInput<V> createInput(ReadableTypedValue<V> property, boolean required);

  /**
   * @return the default {@link io.github.mmm.ui.api.attribute.AttributeWriteValidationFailure#getValidationFailure()
   *         validation failure} message to show if something is invalid (e.g. for
   *         {@link io.github.mmm.ui.api.widget.composite.UiTab}s).
   */
  default String getDefaultValidationFailure() {

    // TODO i18n/NLS
    return "Please enter valid data.";
  }

  /**
   * @return a new instance of {@link UiValidState}.
   */
  default UiValidState newValidState() {

    return new UiValidState();
  }

  /**
   * @return the instance of this {@link UiContext}.
   */
  static UiContext get() {

    return UiContextProvider.CONTEXT;
  }

}