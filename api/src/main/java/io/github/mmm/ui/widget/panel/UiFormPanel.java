/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteValueForUser;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import io.github.mmm.ui.widget.composite.UiValuedComposite;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiDynamicComposite} for a form of {@link UiInput}s as {@link #getChild(int) children} shown vertically from
 * the top to the bottom.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface UiFormPanel<V> extends UiValuedComposite<UiAbstractInput<?>, V>, UiRegularWidget, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @return the new {@link UiFormPanel}.
   */
  static UiFormPanel<Void> of(UiContext context) {

    return context.create(UiFormPanel.class);
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param context the {@link UiContext}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @return the new {@link UiFormGroup}.
   */
  static <V> UiFormPanel<V> of(UiContext context, AttributeWriteValueForUser<V> binding) {

    UiFormPanel<V> widget = context.create(UiFormPanel.class);
    widget.initBinding(binding);
    return widget;
  }

  /**
   * @param <V> type of the {@link #getValue() value}.
   * @param context the {@link UiContext}.
   * @param binding the {@link AttributeWriteValueForUser} defining how to read and write the value.
   * @param children the {@link UiAbstractInput}s to add as children.
   * @return the new {@link UiFormPanel}.
   */
  static <V> UiFormPanel<V> of(UiContext context, AttributeWriteValueForUser<V> binding,
      UiAbstractInput<?>... children) {

    UiFormPanel<V> widget = context.create(UiFormPanel.class);
    widget.initBinding(binding);
    for (UiAbstractInput<?> child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
