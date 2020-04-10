/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.data;

import java.util.Collection;

import io.github.mmm.bean.BeanFactory;
import io.github.mmm.bean.ReadableBean;
import io.github.mmm.bean.WritableBean;
import io.github.mmm.bean.property.ReadableBeanProperty;
import io.github.mmm.entity.id.Id;
import io.github.mmm.entity.link.Link;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.property.WritableProperty;
import io.github.mmm.property.container.ReadableContainerProperty;
import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.factory.UiWidgetFactoryProperty;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.panel.UiFormGroup;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;
import io.github.mmm.validation.Validator;

/**
 * Binding that allows to bind a {@link ReadableProperty property} or an entire {@link ReadableBean bean} to the UI. It
 * can create entire dialogs forms for beans dynamically.
 */
public class UiDataBinding {

  private final PropertyFilter defaultPropertyFilter;

  /**
   * The constructor.
   */
  public UiDataBinding() {

    this(null);
  }

  /**
   * The constructor.
   *
   * @param defaultPropertyFilter the {@link PropertyFilter} to use as default.
   */
  public UiDataBinding(PropertyFilter defaultPropertyFilter) {

    super();
    if (defaultPropertyFilter == null) {
      this.defaultPropertyFilter = PropertyFilterDefault.INSTANCE;
    } else {
      this.defaultPropertyFilter = defaultPropertyFilter;
    }
  }

  public <B extends ReadableBean> UiValidatableWidget<B> createEditor(B bean) {

    return createEditor(bean, 2);
  }

  public <B extends ReadableBean> UiValidatableWidget<B> createEditor(B bean, int columns) {

    // UiResponsiveColumnPanel panel = context.create(UiResponsiveColumnPanel.class);
    // bindBean(bean, panel, columns);
    // return new UiCustomForm<>(this.context, getValue, setValue);
    return null;
  }

  /**
   * @param bean the {@link ReadableBean} to bind.
   * @param receiver the {@link UiBindingReceiver}.
   * @param createGroup - {@code true} to create {@link UiFormGroup}s for nested beans, {@code false} otherwise.
   */
  public void bindBean(ReadableBean bean, UiBindingReceiver receiver, boolean createGroup) {

    bindBean(bean, receiver, createGroup, this.defaultPropertyFilter);
  }

  /**
   * @param bean the {@link ReadableBean} to bind.
   * @param receiver the {@link UiBindingReceiver}.
   * @param createGroup - {@code true} to create {@link UiFormGroup}s for nested beans, {@code false} otherwise.
   * @param propertyFilter the {@link PropertyFilter}.
   */
  public void bindBean(ReadableBean bean, UiBindingReceiver receiver, boolean createGroup,
      PropertyFilter propertyFilter) {

    if (bean == null) {
      return;
    }
    for (ReadableProperty<?> property : bean.getProperties()) {
      if (!propertyFilter.filter(property)) {
        bindProperty(property, bean, receiver, propertyFilter, createGroup);
      }
    }
  }

  private <V> void bindProperty(ReadableProperty<V> property, ReadableBean bean, UiBindingReceiver receiver,
      PropertyFilter propertyFilter, boolean createGroup) {

    if (propertyFilter.filter(property)) {
      return;
    }
    if (property instanceof ReadableBeanProperty) {
      bindBean((ReadableBeanProperty<?>) property, bean, receiver, propertyFilter, createGroup);
    } else {
      createInput(property, bean, receiver, false);
    }
  }

  private <B extends WritableBean> void bindBean(ReadableBeanProperty<B> beanProperty, ReadableBean parentBean,
      UiBindingReceiver receiver, PropertyFilter propertyFilter, boolean createGroup) {

    B childBean = beanProperty.get();
    if (childBean == null) {
      childBean = BeanFactory.get().create(beanProperty.getValueClass());
    }
    if (createGroup) {
      UiFormGroup<B> formGroup = createFormGroup(childBean, beanProperty, parentBean, propertyFilter);
      receiver.add(beanProperty, formGroup);
    } else {
      bindBean(childBean, receiver, false, propertyFilter);
    }
  }

  /**
   * @param <B> type of {@link WritableBean}.
   * @param bean the {@link WritableBean}.
   * @return the {@link UiFormGroup}.
   */
  public <B extends WritableBean> UiFormPanel<B> createFormPanel(B bean) {

    return createFormPanel(bean, this.defaultPropertyFilter);
  }

  /**
   * @param <B> type of {@link WritableBean}.
   * @param bean the {@link WritableBean}.
   * @param propertyFilter the {@link PropertyFilter}.
   * @return the {@link UiFormGroup}.
   */
  public <B extends WritableBean> UiFormPanel<B> createFormPanel(B bean, PropertyFilter propertyFilter) {

    UiBindingReceiverImpl<B> binding = new UiBindingReceiverImpl<>(bean);
    bindBean(bean, binding, true, propertyFilter);
    Collection<UiAbstractInput<?>> inputs = binding.getInputs();
    if (inputs.isEmpty()) {
      return null;
    }
    UiFormPanel<B> formPanel = UiFormPanel.of(binding);
    for (UiAbstractInput<?> input : inputs) {
      formPanel.addChild(input);
    }
    return formPanel;
  }

  /**
   * @param <B> type of {@link WritableBean}.
   * @param bean the {@link WritableBean}.
   * @param beanProperty the {@link ReadableBeanProperty}.
   * @param parentBean the parent {@link ReadableBean bean}.
   * @param propertyFilter the {@link PropertyFilter}.
   * @return the {@link UiFormGroup}.
   */
  public <B extends WritableBean> UiFormGroup<B> createFormGroup(B bean, ReadableBeanProperty<B> beanProperty,
      ReadableBean parentBean, PropertyFilter propertyFilter) {

    String groupName = localizeLabel(beanProperty, parentBean);
    UiBindingReceiverImpl<B> binding = new UiBindingReceiverImpl<>(bean);
    bindBean(bean, binding, false, propertyFilter);
    Collection<UiAbstractInput<?>> inputs = binding.getInputs();
    if (inputs.isEmpty()) {
      return null;
    }
    UiFormGroup<B> formGroup = UiFormGroup.of(binding, groupName);
    for (UiAbstractInput<?> input : inputs) {
      formGroup.addChild((UiInput<?>) input);
    }
    return formGroup;
  }

  /**
   * @param property the {@link ReadableProperty} to test.
   * @return {@code true} if the given {@code property} should be bound to the UI, {@code false} otherwise.
   */
  protected boolean isBindableProperty(ReadableProperty<?> property) {

    if (property instanceof ReadableContainerProperty) {
      return isBindableProperty(((ReadableContainerProperty<?, ?>) property).getValueProperty());
    }
    Class<?> valueClass = property.getValueClass();
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
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null} but is
   *        required for advanced localization (if you want more specific labels in case the
   *        {@link WritableProperty#getName() property name} is not specific enough).
   * @param receiver the {@link UiBindingReceiver}. May be {@code null}.
   * @param bindValue {@code true} to bind the value of the {@link ReadableProperty} bidirectional with the
   *        {@link UiInput}.
   * @return the {@link UiInput} widget for the given {@link ReadableProperty property}.
   */
  public <V> UiInput<V> createInput(ReadableProperty<V> property, Object source, UiBindingReceiver receiver,
      boolean bindValue) {

    UiInput<V> input = UiWidgetFactoryProperty.get().create(property);
    input.setId(createId(property, source));
    bindProperty(property, input, source, bindValue);
    if (receiver != null) {
      receiver.add(property, input);
    }
    return input;
  }

  /**
   * @param property the {@link ReadableProperty} to bind.
   * @param input the {@link UiInput} to bind.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null} but is
   *        required for advanced localization (if you want more specific labels in case the
   *        {@link WritableProperty#getName() property name} is not specific enough).
   * @param bindValue {@code true} to bind the value of the {@link ReadableProperty} bidirectional with the
   *        {@link UiInput}.
   * @param <V> type of the value.
   */
  public <V> void bindProperty(ReadableProperty<V> property, UiInput<V> input, Object source, boolean bindValue) {

    Validator<? super V> validator = property.getMetadata().getValidator();
    input.setValidator(validator);
    String label = localizeLabel(property, source);
    input.setName(label);
    boolean readOnly = property.isReadOnly();
    if (readOnly) {
      input.setReadOnlyFixed(Boolean.TRUE);
    } else {
      if (bindValue) {
        final WritableProperty<V> writableProperty = (WritableProperty<V>) property;
        input.addListener((e) -> {
          if (e.getType() == UiValueChangeEvent.TYPE) {
            V value = input.getValue();
            writableProperty.set(value);
          }
        });
      }
    }
    if (bindValue) {
      property.addListener((e) -> {
        if (!e.isChange()) {
          V value = property.get();
          input.setValue(value);
        }
      }, true);
    }
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
   * @param property the {@link ReadableProperty}.
   * @param source the optional {@link Object} (e.g. {@code Bean}) owning the property. May be {@code null}.
   * @return the localized label {@link String}.
   */
  protected String localizeLabel(ReadableProperty<?> property, Object source) {

    String propertyName = property.getName();
    // TODO perform I18N
    return propertyName;
  }

}
