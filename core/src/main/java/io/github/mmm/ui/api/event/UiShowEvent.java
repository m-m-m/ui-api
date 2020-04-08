/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiVisibilityEvent} for a {@link UiWidget} that is shown (set visible).
 *
 * @see UiWidget#setVisible(boolean)
 * @since 1.0.0
 */
public class UiShowEvent extends UiVisibilityEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("show");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   */
  public UiShowEvent(UiWidget source) {

    super(source, true);
  }

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiShowEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiShowEvent}.
   */
  public static UiShowEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiShowEvent(source, programmaticEventType == TYPE);
  }
}
