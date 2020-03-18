/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.github.mmm.bean.WritableBean;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.ui.UiValueBinding;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.value.UiBindableWidget;

/**
 * Implementation of {@link UiBindingReceiver}.
 *
 * @param <B> type of {@link WritableBean}.
 * @since 1.0.0
 */
public class UiBindingReceiverImpl<B extends WritableBean> implements UiBindingReceiver, UiValueBinding<B> {

  private final B bean;

  private final Map<String, UiAbstractInput<?>> propertyName2InputMap;

  private UiBindableWidget<B> widget;

  private B value;

  private long modificationTimestamp;

  /**
   * The constructor.
   *
   * @param bean the {@link WritableBean} to use as template for the binding.
   */
  public UiBindingReceiverImpl(B bean) {

    super();
    this.bean = bean;
    this.propertyName2InputMap = new HashMap<>();
    this.modificationTimestamp = -1;
  }

  @Override
  public void setWidget(UiBindableWidget<B> widget) {

    assert (this.widget == null);
    this.widget = widget;
  }

  @Override
  public B getValue() {

    long ts = -1;
    if (this.widget != null) {
      ts = this.widget.getModificationTimestamp();
      if (ts < this.modificationTimestamp) {
        return this.value;
      }
    }
    B result = WritableBean.newInstance(this.bean);
    for (Map.Entry<String, UiAbstractInput<?>> entry : this.propertyName2InputMap.entrySet()) {
      String propertyName = entry.getKey();
      UiAbstractInput<?> input = entry.getValue();
      result.set(propertyName, input.getValue());
    }
    this.value = result;
    this.modificationTimestamp = ts;
    System.out.println("Created new value " + result);
    return result;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void setValue(B newBean, boolean forUser) {

    for (Map.Entry<String, UiAbstractInput<?>> entry : this.propertyName2InputMap.entrySet()) {
      String propertyName = entry.getKey();
      Object propertyValue = null;
      if (newBean != null) {
        propertyValue = newBean.get(propertyName);
      }
      UiAbstractInput input = entry.getValue();
      input.setValue(propertyValue, forUser);
    }
    this.value = newBean;
    updateModificationTimestamp(!forUser);
  }

  private void updateModificationTimestamp(boolean reset) {

    if (reset) {
      this.modificationTimestamp = -1;
    } else {
      this.modificationTimestamp = System.currentTimeMillis();
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
