/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.form;

import io.github.mmm.ui.api.widget.AbstractUiCustomWidget;
import io.github.mmm.ui.api.widget.composite.UiCustomValuedComposite;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class UiCustomFormPanel<V> extends UiCustomValuedComposite<V, UiAbstractInput<?>, UiFormPanel<V>>
    implements UiFormPanel<V> {

  /**
   * The constructor.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public UiCustomFormPanel() {

    super((UiFormPanel) UiFormPanel.of());
  }

  /**
   * The constructor.
   *
   * @param delegate the {@link UiFormPanel}.
   */
  public UiCustomFormPanel(UiFormPanel<V> delegate) {

    super(delegate);
  }

}
