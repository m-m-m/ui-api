/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiSeverity;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.factory.UiWidgetFactoryDatatype;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.button.UiButton;
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

  /**
   * @param key the {@link ResourceBundle#getString(String) key}.
   * @return the localized text.
   */
  protected String localize(String key) {

    try {
      return getBundle().getString(key);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * This method gets the title for the given {@link UiSeverity}.
   *
   * @param severity is the {@link UiSeverity}.
   * @return the according title.
   * @see #showPopup(String, UiSeverity, String, String, UiAction...)
   */
  protected String getTitle(UiSeverity severity) {

    return getBundle().getString(severity.getName());
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

  @Override
  public UiButton createButton(UiAction action) {

    Objects.requireNonNull(action, "action");
    String id = action.getId();
    Objects.requireNonNull(id, "id");
    UiButton button = create(UiButton.class);
    button.setId(id);
    String label = action.getLabel();
    if (label == null) {
      label = localize(id);
      if (label == null) {
        label = CaseHelper.capitalize(id);
      }
    }
    button.setLabel(label);
    String tooltip = action.getTooltip();
    if (tooltip == null) {
      tooltip = localize(id + "_tooltip");
    }
    if (tooltip != null) {
      button.setTooltip(tooltip);
    }
    UiEventListener listener = action;
    if (action.requireConfirmation()) {
      String message = action.getConfirmationMessage();
      if (message == null) {
        message = localize(id + "_confirm");
      }
      if (message == null) {
        message = "Are you sure?";
      }
      final String finalMessage = message;
      listener = (e) -> {
        Consumer<Boolean> callback = (choice) -> {
          if (Boolean.TRUE.equals(choice)) {
            action.onEvent(e);
          }
        };
        showPopupYesNo(finalMessage, null, callback);
      };
    }
    button.addListener(listener);
    return button;
  }

}
