/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.custom;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;

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
   *
   * @param context the {@link #getContext() context}.
   */
  public UiCustomFormPanel(UiContext context) {

    super(context.create(UiFormPanel.class));
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
