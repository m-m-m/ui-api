/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.composite.UiCollapsibleComposite;
import io.github.mmm.ui.api.widget.composite.UiValuedComposite;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiAbstractCompositeInput} as {@link UiNativeWidget native widget} without {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiFormGroup<V> extends UiValuedComposite<UiInput<?>, V>, UiCollapsibleComposite<UiInput<?>>,
    UiAbstractCompositeInput<UiInput<?>, V>, UiNativeWidget {

  @Override
  default boolean isValid() {

    return UiValuedComposite.super.isValid();
  }

  @Override
  default void reset() {

    UiValuedComposite.super.reset();
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiFormGroup}.
   */
  static UiFormGroup<Void> of(String name) {

    UiFormGroup<Void> widget = UiWidgetFactoryNative.get().create(UiFormGroup.class);
    if (name != null) {
      widget.setName(name);
    }
    return widget;
  }

  /**
   * @param name the {@link #getName() name} (label).
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormGroup}.
   */
  static UiFormGroup<Void> of(String name, UiInput<?>... children) {

    UiFormGroup<Void> widget = of(name);
    for (UiInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param context the {@link UiContext}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiFormGroup}.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  static <V> UiFormGroup<V> of(UiValueBinding<V> binding, String name) {

    UiFormGroup<V> widget = (UiFormGroup) of(name);
    widget.initBinding(binding);
    return widget;
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @param name the {@link #getName() name} (label).
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormGroup}.
   */
  static <V> UiFormGroup<V> of(UiValueBinding<V> binding, String name, UiInput<?>... children) {

    UiFormGroup<V> widget = of(binding, name);
    for (UiInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
