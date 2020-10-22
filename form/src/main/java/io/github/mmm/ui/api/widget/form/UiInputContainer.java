/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableSingleComposite;
import io.github.mmm.ui.api.widget.input.UiInput;

/**
 * {@link UiRegularWidget} for the {@link UiInput#getContainerWidget() container} of a {@link UiInput}. It composes the
 * {@link UiInput} itself together with its {@link UiInput#getNameWidget() name widget} (label).
 *
 * @param <V> type of the {@link UiInput#getValue() input value}.
 * @see UiInput#getContainerWidget()
 * @see #of(UiInput)
 */
public interface UiInputContainer<V> extends UiMutableSingleComposite<UiInput<V>>, UiRegularWidget, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name for an input container. */
  String STYLE = "ui-inputcontainer";

  /**
   * @return the contained {@link UiInput}. Will initially be {@code null} but is set on initialization and will never
   *         be {@code null} if retrieved via {@link UiInput#getContainerWidget()}.
   */
  @Override
  UiInput<V> getChild();

  /**
   * @param child the {@link UiInput} to set as {@link #getChild() child}. May only be set from {@link UiInput} itself.
   *        Once set, it can not be changed anymore.
   */
  @Override
  void setChild(UiInput<V> child);

  /**
   * <b>ATTENTION:</b> Instances of {@link UiInputContainer} shall only be created from {@link UiInput} for
   * {@link UiInput#getContainerWidget()}.
   *
   * @param <V> type of the {@link UiInput#getValue() input value}.
   * @param input the {@link UiInput} to associate.
   * @return the new {@link UiInputContainer}.
   */
  static <V> UiInputContainer<V> of(UiInput<V> input) {

    UiInputContainer<V> widget = UiWidgetFactoryNative.get().create(UiInputContainer.class);
    widget.setChild(input);
    return widget;
  }

}
