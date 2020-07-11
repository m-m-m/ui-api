/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

/**
 * {@link UiEventListener} for {@link UiSelectionEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiSelectionEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiSelectionEvent) {
      onSelection((UiSelectionEvent) event);
    }
  }

  /**
   * Called when the selection changed (something has been selected or unselected).
   * 
   * @param event the {@link UiSelectionEvent}.
   */
  void onSelection(UiSelectionEvent event);

}
