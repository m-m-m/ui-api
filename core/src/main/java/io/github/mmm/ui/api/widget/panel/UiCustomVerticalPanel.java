/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

/**
 * {@link UiCustomMutablePanel} that is a {@link UiVerticalPanel}.
 *
 * @since 1.0.0
 */
public abstract class UiCustomVerticalPanel extends UiCustomMutablePanel<UiVerticalPanel> implements UiVerticalPanel {

  /**
   * The constructor.
   */
  public UiCustomVerticalPanel() {

    this(UiVerticalPanel.of());
  }

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public UiCustomVerticalPanel(UiVerticalPanel delegate) {

    super(delegate);
  }

}
