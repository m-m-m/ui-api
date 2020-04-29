/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;

/**
 * {@link AbstractUiCustomWidget} that is a {@link UiFormPanel}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class UiCustomFormPanel<V> extends UiCustomValuedComposite<UiFormPanel<V>, UiAbstractInput<?>, V>
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
