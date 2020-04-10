/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import java.util.Locale;
import java.util.ResourceBundle;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.input.UiInput;
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

  private Locale locale;

  private ResourceBundle bundle;

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
    this.locale = Locale.getDefault();
  }

  @Override
  public Locale getLocale() {

    return this.locale;
  }

  /**
   * @param locale new value of {@link #getLocale()}.
   */
  public void setLocale(Locale locale) {

    if (locale == null) {
      locale = Locale.ROOT;
    }
    this.locale = locale;
  }

  /**
   * @return the {@link ResourceBundle} for localization.
   */
  protected ResourceBundle getBundle() {

    if (this.bundle == null) {
      this.bundle = ResourceBundle.getBundle("io.github.mmm.ui.nls.NlsBundleUi", this.locale);
    }
    return this.bundle;
  }

  @Override
  public String localize(String key) {

    try {
      return getBundle().getString(key);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required) {

    return this.nativeFactory.create(widgetInterface, required);
  }

  @Override
  public <V> UiInput<V> createInput(Class<V> datatype, boolean required) {

    return this.datatypeFactory.create(datatype, required);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V> UiInput<V> createInput(ReadableTypedValue<V> property, boolean required) {

    Class<? extends ReadableTypedValue<V>> propertyType = (Class<? extends ReadableTypedValue<V>>) property.getClass();
    UiInput<V> input = this.propertyFactory.create(propertyType, false);
    if (input == null) {
      input = createInput(property.getValueClass(), required);
    }
    return input;
  }

}
