/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiEvent} for a {@link UiWidget} that changed its value.
 */
public class UiValueChangeEvent extends UiEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("value");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiValueChangeEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiValueChangeEvent}.
   */
  public static UiValueChangeEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiValueChangeEvent(source, programmaticEventType == TYPE);
  }
}
