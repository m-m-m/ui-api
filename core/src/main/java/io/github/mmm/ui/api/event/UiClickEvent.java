/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiEvent} for a click.
 */
public class UiClickEvent extends UiEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("click");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiClickEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiClickEvent}.
   */
  public static UiClickEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiClickEvent(source, programmaticEventType == TYPE);
  }
}
