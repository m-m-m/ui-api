/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import io.github.mmm.bean.ReadableBean;
import io.github.mmm.bean.WritableBean;
import io.github.mmm.bean.property.ReadableBeanProperty;
import io.github.mmm.entity.id.Id;
import io.github.mmm.entity.link.Link;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.property.WritableProperty;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.panel.UiFormGroup;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiResponsiveColumnPanel;
import io.github.mmm.validation.Validator;

/**
 * Binding that allows to bind a {@link ReadableProperty property} or an entire {@link ReadableBean bean} to the UI. It
 * can create entire dialogs forms for beans dynamically.
 */
public class UiBinding {

  /**
   * The constructor.
   */
  public UiBinding() {

    super();
  }

  public <B extends ReadableBean> UiResponsiveColumnPanel/* <B> */ createEditor(B bean, UiContext context) {

    return createEditor(bean, context, 2);
  }

  public <B extends ReadableBean> UiResponsiveColumnPanel/* <B> */ createEditor(B bean, UiContext context,
      int columns) {

    UiResponsiveColumnPanel panel = context.create(UiResponsiveColumnPanel.class);
    bindBean(bean, panel, columns);
    return panel;
  }

  /**
   * @param bean the {@link ReadableBean} to bind.
   * @param panel the {@link UiResponsiveColumnPanel} where to add the input widgets.
   * @param columns the number of columns.
   */
  public void bindBean(ReadableBean bean, UiResponsiveColumnPanel panel, int columns) {

    UiContext context = panel.getContext();
    UiFormPanel mainForm = null;
    for (ReadableProperty<?> property : bean.getProperties()) {
      UiAbstractInput<?> input = null;
      Class<?> valueClass = property.getValueClass();
      if (property instanceof ReadableBeanProperty) {
        input = createFormGroup((ReadableBeanProperty<?>) property, context);
      } else if (isBindableValueClass(valueClass)) { // TODO use Predicate
        input = createInput(property, context, bean);
      }
      if (input != null) {
        if (mainForm == null) {
          mainForm = context.createFormPanel();
          panel.addChild(mainForm);
        }
        mainForm.addChild(input);
      }
    }
  }

  /**
   * @param bean
   * @param context
   * @return
   */
  protected <B extends WritableBean> UiFormGroup<B> createFormGroup(ReadableBeanProperty<B> beanProperty,
      UiContext context) {

    WritableBean bean = beanProperty.get();
    if (bean == null) {
      return null;
    }
    UiFormGroup<B> formGroup = null;
    return formGroup;
  }

  /**
   * @param valueClass the {@link ReadableProperty#getValueClass() value class}.
   * @return {@code true} if properties of the given {@link ReadableProperty#getValueClass() value class} should be
   *         bound to the UI, {@code false} otherwise.
   */
  protected boolean isBindableValueClass(Class<?> valueClass) {

    if (Id.class.isAssignableFrom(valueClass)) {
      return false;
    } else if (Link.class.isAssignableFrom(valueClass)) {
      return false;
    }
    return true;
  }

  /**
   * @param <V> type of the {@link ReadableProperty#get() property value}.
   * @param property the {@link ReadableProperty}.
   * @param context the {@link UiContext}.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null} but is
   *        required for advanced localization (if you want more specific labels in case the
   *        {@link WritableProperty#getName() property name} is not specific enough).
   * @return the {@link UiInput} widget for the given {@link ReadableProperty property}.
   */
  public <V> UiInput<V> createInput(ReadableProperty<V> property, UiContext context, Object source) {

    UiInput<V> input = context.createInput(property);
    input.setId(createId(property, source));
    bindProperty(property, input, source);
    return input;
  }

  /**
   * @param property the {@link ReadableProperty} to bind.
   * @param input the {@link UiInput} to bind.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null} but is
   *        required for advanced localization (if you want more specific labels in case the
   *        {@link WritableProperty#getName() property name} is not specific enough).
   * @param <V> type of the value.
   */
  public <V> void bindProperty(ReadableProperty<V> property, UiInput<V> input, Object source) {

    Validator<? super V> validator = property.getMetadata().getValidator();
    input.setValidator(validator);
    String label = localizeLabel(input.getContext(), property, source);
    input.setName(createFieldLabel(label, validator.isMandatory(), property, source));
    boolean readOnly = property.isReadOnly();
    if (readOnly) {
      input.setReadOnlyFixed(Boolean.TRUE);
    } else {
      final WritableProperty<V> writableProperty = (WritableProperty<V>) property;
      input.addListener((e) -> {
        if (e.getType() == UiValueChangeEvent.TYPE) {
          V value = input.getValue();
          writableProperty.set(value);
        }
      });
    }
    property.addListener((e) -> {
      if (!e.isChange()) {
        V value = property.get();
        input.setValue(value);
      }
    }, true);
  }

  /**
   * @param property the {@link ReadableProperty}.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null}.
   * @return the widget ID.
   */
  protected String createId(ReadableProperty<?> property, Object source) {

    String propertyName = property.getName();
    if (source == null) {
      return propertyName;
    }
    return source.getClass().getSimpleName() + "_" + propertyName;
  }

  /**
   * @param context the {@link UiContext}.
   * @param property the {@link ReadableProperty}.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null}.
   * @return the localized label {@link String}.
   */
  protected String localizeLabel(UiContext context, ReadableProperty<?> property, Object source) {

    String propertyName = property.getName();
    // TODO Auto-generated method stub
    return propertyName;
  }

  /**
   * @param label the localized label.
   * @param mandatory the {@link Validator#isMandatory() mandatory} flag of the {@link ReadableProperty property}.
   * @param property the {@link ReadableProperty}.
   * @param source the the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null}.
   * @return the final label text.
   */
  protected String createFieldLabel(String label, boolean mandatory, ReadableProperty<?> property, Object source) {

    if (mandatory) {
      return label + "*:";
    } else {
      return label + ":";
    }
  }

}
