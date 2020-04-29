/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.api.binding.UiValueBinding;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;
import io.github.mmm.ui.api.widget.composite.UiValuedComposite;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiMutableComposite} for a form of {@link UiInput}s as {@link #getChild(int) children} shown vertically from
 * the top to the bottom.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiFormPanel<V> extends UiValuedComposite<UiAbstractInput<?>, V>, UiRegularWidget, UiNativeWidget {

  /**
   * @return the new {@link UiFormPanel}.
   */
  static UiFormPanel<Void> of() {

    return UiWidgetFactoryNative.get().create(UiFormPanel.class);
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormPanel}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  static <V> UiFormPanel<V> of(UiAbstractInput<?>... children) {

    UiFormPanel<V> widget = (UiFormPanel) of();
    for (UiAbstractInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

  /**
   * @param binding the {@link UiValueBinding} defining how to read and write the value.
   * @param <V> type of the {@link #getValue() value}.
   * @return the new {@link UiFormGroup}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  static <V> UiFormPanel<V> of(UiValueBinding<V> binding) {

    UiFormPanel<V> widget = (UiFormPanel) of();
    widget.initBinding(binding);
    return widget;
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param binding the {@link UiValueBinding} defining how to read and write the value.
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormPanel}.
   */
  static <V> UiFormPanel<V> of(UiValueBinding<V> binding, UiAbstractInput<?>... children) {

    UiFormPanel<V> widget = of(binding);
    for (UiAbstractInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
