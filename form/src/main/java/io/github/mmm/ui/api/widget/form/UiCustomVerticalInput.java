/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;

/**
 * {@link UiCustomCompositeInput} that is a {@link UiVerticalInput}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomVerticalInput<V> extends UiCustomCompositeInput<V, UiVerticalInput<V>>
    implements UiVerticalInput<V> {

  /**
   * The constructor.
   */
  public UiCustomVerticalInput() {

    super(UiWidgetFactoryNative.get().create(UiVerticalInput.class));
  }

  /**
   * The constructor.
   *
   * @param delegate the {@link UiHorizontalInput}.
   */
  public UiCustomVerticalInput(UiVerticalInput<V> delegate) {

    super(delegate);
  }

}
