/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiEnablingEvent} for a {@link UiWidget} that is disabled.
 *
 * @see UiWidget#setEnabled(boolean)
 * @since 1.0.0
 */
public class UiDisableEvent extends UiEnablingEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("disable");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   */
  public UiDisableEvent(UiWidget source) {

    super(source, true);
  }

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiDisableEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  @Override
  public boolean isEnabled() {

    return false;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiDisableEvent}.
   */
  public static UiDisableEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiDisableEvent(source, programmaticEventType == TYPE);
  }
}
