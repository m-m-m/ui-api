/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.datatype.UiScrollBarVisibility;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiCustomMutableSingleComposite;

/**
 * {@link UiCustomMutableSingleComposite} that is a {@link UiScrollPanel}.
 *
 * @since 1.0.0
 */
public abstract class UiCustomScrollPanel extends UiCustomMutableSingleComposite<UiRegularWidget, UiScrollPanel>
    implements UiScrollPanel {

  /**
   * The constructor.
   */
  public UiCustomScrollPanel() {

    this(UiScrollPanel.of());
  }

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomScrollPanel(UiScrollPanel delegate) {

    super(delegate);
  }

  @Override
  public UiScrollBarVisibility getHorizontalScrolling() {

    return this.delegate.getHorizontalScrolling();
  }

  @Override
  public void setHorizontalScrolling(UiScrollBarVisibility scrolling) {

    this.delegate.setHorizontalScrolling(scrolling);
  }

  @Override
  public UiScrollBarVisibility getVerticalScrolling() {

    return this.delegate.getVerticalScrolling();
  }

  @Override
  public void setVerticalScrolling(UiScrollBarVisibility scrolling) {

    this.delegate.setVerticalScrolling(scrolling);
  }

}
