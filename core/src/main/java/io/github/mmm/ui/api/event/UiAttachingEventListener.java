/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

/**
 * {@link UiEventListener} for {@link UiAttachingEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiAttachingEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiAttachingEvent) {
      onAttachingChange((UiAttachingEvent) event);
    }
  }

  /**
   * @param event the {@link UiAttachingEvent}.
   */
  void onAttachingChange(UiAttachingEvent event);

}
