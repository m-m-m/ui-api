/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.attribute.AttributeReadAttached;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiAttachingEvent} for a {@link UiWidget} that is {@link AttributeReadAttached#isAttached() detached} from the UI.
 *
 * @see UiWidget#isAttached()
 * @since 1.0.0
 */
public class UiDetachEvent extends UiAttachingEvent {

  /** @see #getType() */
  public static final UiEventType TYPE = new UiEventType("detach");

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   */
  public UiDetachEvent(UiWidget source) {

    super(source, true);
  }

  @Override
  public UiEventType getType() {

    return TYPE;
  }

  @Override
  public boolean isAttached() {

    return false;
  }

}
