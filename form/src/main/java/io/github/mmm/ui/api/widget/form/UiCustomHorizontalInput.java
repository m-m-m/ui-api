/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomHorizontalInput<V> extends UiCustomCompositeInput<V, UiHorizontalInput<V>> implements UiHorizontalInput<V> {

  /**
   * The constructor.
   */
  public UiCustomHorizontalInput() {

    super(UiWidgetFactoryNative.get().create(UiHorizontalInput.class));
  }

  /**
   * The constructor.
   *
   * @param delegate the {@link UiHorizontalInput}.
   */
  public UiCustomHorizontalInput(UiHorizontalInput<V> delegate) {

    super(delegate);
  }

}
