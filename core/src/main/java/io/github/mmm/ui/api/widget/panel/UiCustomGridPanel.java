/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiCustomRemovableComposite;

/**
 * {@link UiCustomMutablePanel} that is a {@link UiGridPanel}.
 *
 * @since 1.0.0
 */
public abstract class UiCustomGridPanel extends UiCustomRemovableComposite<UiGridRow, UiGridPanel>
    implements UiGridPanel {

  /**
   * The constructor.
   */
  public UiCustomGridPanel() {

    this(UiGridPanel.of());
  }

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomGridPanel(UiGridPanel delegate) {

    super(delegate);
  }

  @Override
  public UiGridRow addRow() {

    return this.delegate.addRow();
  }

  @Override
  public UiGridRow addRow(UiRegularWidget... children) {

    return this.delegate.addRow(children);
  }

  @Override
  public UiGridRow addRow(int index) {

    return this.delegate.addRow(index);
  }

  @Override
  public UiGridRow addRow(int index, UiRegularWidget... children) {

    return this.delegate.addRow(index, children);
  }

}
