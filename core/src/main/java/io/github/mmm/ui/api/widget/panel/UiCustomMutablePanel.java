/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiCustomMutableComposite;

/**
 * {@link UiCustomMutableComposite} that is a {@link UiMutablePanel}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 * @since 1.0.0
 */
public abstract class UiCustomMutablePanel<W extends UiMutablePanel>
    extends UiCustomMutableComposite<UiRegularWidget, W> implements UiMutablePanel {

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomMutablePanel(W delegate) {

    super(delegate);
  }

}
