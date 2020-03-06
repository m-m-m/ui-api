/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.github.mmm.bean.WritableBean;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.ui.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.widget.input.UiAbstractInput;

/**
 * Implementation of {@link UiBindingReceiver}.
 *
 * @param <B> type of {@link WritableBean}.
 * @since 1.0.0
 */
public class UiBindingReceiverImpl<B extends WritableBean> implements UiBindingReceiver, AttributeWriteValueForUser<B> {

  private final B bean;

  private final Map<String, UiAbstractInput<?>> propertyName2InputMap;

  /**
   * The constructor.
   *
   * @param bean the {@link WritableBean} to use as template for the binding.
   */
  public UiBindingReceiverImpl(B bean) {

    super();
    this.bean = bean;
    this.propertyName2InputMap = new HashMap<>();
  }

  @Override
  public B getValue() {

    B result = WritableBean.newInstance(this.bean);
    for (Map.Entry<String, UiAbstractInput<?>> entry : this.propertyName2InputMap.entrySet()) {
      String propertyName = entry.getKey();
      UiAbstractInput<?> input = entry.getValue();
      result.set(propertyName, input.getValue());
    }
    return result;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void setValue(B newBean, boolean forUser) {

    for (Map.Entry<String, UiAbstractInput<?>> entry : this.propertyName2InputMap.entrySet()) {
      String propertyName = entry.getKey();
      Object value = null;
      if (newBean != null) {
        value = newBean.get(propertyName);
      }
      UiAbstractInput input = entry.getValue();
      input.setValue(value, forUser);
    }
  }

  @Override
  public <V> void add(ReadableProperty<V> property, UiAbstractInput<V> input) {

    this.propertyName2InputMap.put(property.getName(), input);
  }

  /**
   * @return the {@link Collection} of the {@link UiAbstractInput}s.
   */
  public Collection<UiAbstractInput<?>> getInputs() {

    return this.propertyName2InputMap.values();
  }

}
