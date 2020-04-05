/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiEvent} for a change of the visibility.
 *
 * @see UiWidget#setVisible(boolean)
 * @since 1.0.0
 */
public abstract class UiVisibilityEvent extends UiEvent {

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiVisibilityEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  /**
   * @param visible {@code true} for {@link UiShowEvent} and {@code false} for {@link UiHideEvent}.
   * @return the according {@link #getType() event type}.
   */
  public static UiEventType getType(boolean visible) {

    if (visible) {
      return UiShowEvent.TYPE;
    } else {
      return UiHideEvent.TYPE;
    }
  }

}
