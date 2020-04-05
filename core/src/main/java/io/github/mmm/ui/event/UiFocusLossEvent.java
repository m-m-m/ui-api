/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiFocusEvent} for a {@link UiWidget} that lost the focus.
 *
 * @see io.github.mmm.ui.widget.UiActiveWidget#setFocused()
 * @since 1.0.0
 */
public class UiFocusLossEvent extends UiFocusEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("blur");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiFocusLossEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiFocusLossEvent}.
   */
  public static UiFocusLossEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiFocusLossEvent(source, programmaticEventType == TYPE);
  }
}
