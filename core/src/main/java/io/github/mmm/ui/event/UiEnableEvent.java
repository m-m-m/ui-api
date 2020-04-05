/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiEnablingEvent} for a {@link UiWidget} that is enabled.
 *
 * @see UiWidget#setEnabled(boolean)
 * @since 1.0.0
 */
public class UiEnableEvent extends UiEnablingEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("enable");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   */
  public UiEnableEvent(UiWidget source) {

    super(source, true);
  }

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiEnableEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiEnableEvent}.
   */
  public static UiEnableEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiEnableEvent(source, programmaticEventType == TYPE);
  }
}
