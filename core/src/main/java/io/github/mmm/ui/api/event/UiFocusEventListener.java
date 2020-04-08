/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

/**
 * {@link UiEventListener} for {@link UiFocusEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiFocusEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiFocusEvent) {
      onFocusChange((UiFocusEvent) event);
    }
  }

  /**
   * @param event the {@link UiFocusEvent}.
   */
  void onFocusChange(UiFocusEvent event);

}
