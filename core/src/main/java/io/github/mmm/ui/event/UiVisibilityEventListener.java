/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

/**
 * {@link UiEventListener} for {@link UiVisibilityEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiVisibilityEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiVisibilityEvent) {
      onVisibilityChange((UiVisibilityEvent) event);
    }
  }

  /**
   * @param event the {@link UiVisibilityEvent}.
   */
  void onVisibilityChange(UiVisibilityEvent event);

}
