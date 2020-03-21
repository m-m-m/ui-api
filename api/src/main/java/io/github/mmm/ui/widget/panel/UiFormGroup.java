/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.binding.UiValueBinding;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithCollapse;
import io.github.mmm.ui.widget.composite.UiValuedComposite;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiAbstractCompositeInput} as {@link UiNativeWidget native widget} without {@link #getValue() value}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiFormGroup<V> extends UiValuedComposite<UiInput<?>, V>, UiAbstractCompositeInput<UiInput<?>, V>,
    UiWidgetWithCollapse, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @return the new {@link UiFormGroup}.
   */
  static UiFormGroup<Void> of(UiContext context, String name) {

    UiFormGroup<Void> widget = context.create(UiFormGroup.class);
    widget.setName(name);
    return widget;
  }

  /**
   * @param context the {@link UiContext}.
   * @param name the {@link #getName() name} (label).
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormGroup}.
   */
  static UiFormGroup<Void> of(UiContext context, String name, UiInput<?>... children) {

    UiFormGroup<Void> widget = context.create(UiFormGroup.class);
    widget.setName(name);
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
  static <V> UiFormGroup<V> of(UiContext context, UiValueBinding<V> binding, String name) {

    UiFormGroup<V> widget = context.create(UiFormGroup.class);
    widget.setName(name);
    widget.initBinding(binding);
    return widget;
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param context the {@link UiContext}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @param name the {@link #getName() name} (label).
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormGroup}.
   */
  static <V> UiFormGroup<V> of(UiContext context, UiValueBinding<V> binding, String name, UiInput<?>... children) {

    UiFormGroup<V> widget = context.create(UiFormGroup.class);
    widget.setName(name);
    widget.initBinding(binding);
    for (UiInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
