/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.attribute.AttributeReadAttached;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiEvent} for a change of the {@link UiWidget#isAttached() attached state}.<br>
 * <b>ATTENTION:</b> The {@link UiWidget#isAttached() attached state} will always change for an entire sub-tree of
 * {@link UiWidget}s. The {@link #getSource() source} of this even will therefore be the top-most {@link UiWidget} even
 * when a {@link UiAttachingEventListener listener} is registered for an descendant from the sub-tree.
 *
 * @see UiWidget#isAttached()
 * @since 1.0.0
 */
public abstract class UiAttachingEvent extends UiEvent implements AttributeReadAttached {

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiAttachingEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

  /**
   * @param attached {@code true} for {@link UiAttachEvent} and {@code false} for {@link UiDetachEvent}.
   * @return the according {@link #getType() event type}.
   */
  public static UiEventType getType(boolean attached) {

    if (attached) {
      return UiAttachEvent.TYPE;
    } else {
      return UiDetachEvent.TYPE;
    }
  }

  /**
   * @param source the {@link #getSource() source} of the event.
   * @param attached {@code true} for {@link UiAttachEvent} and {@code false} for {@link UiDetachEvent}.
   * @return the new {@link UiAttachingEvent} of the given {@link #getType() type}.
   */
  public static UiAttachingEvent of(UiWidget source, boolean attached) {

    if (attached) {
      return new UiAttachEvent(source);
    } else {
      return new UiDetachEvent(source);
    }
  }

}
