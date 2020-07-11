/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.attribute.AttributeWriteSelection;
import io.github.mmm.ui.api.attribute.AttributeWriteSelections;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiEvent} if the selection changed (something was selected or unselected).
 *
 * @see AttributeWriteSelection#setSelection(Object)
 * @see AttributeWriteSelections#setSelections(java.util.Collection)
 * @since 1.0.0
 */
public class UiSelectionEvent extends UiEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("selection");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiSelectionEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  /**
   * @param source the {@link #getSource() source widget}.
   * @param programmaticEventType the {@link UiEventType} marked as programmatic.
   * @return the new {@link UiSelectionEvent}.
   */
  public static UiSelectionEvent of(UiWidget source, UiEventType programmaticEventType) {

    return new UiSelectionEvent(source, programmaticEventType == TYPE);
  }
}
