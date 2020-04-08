/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

/**
 * {@link UiEventListener} for {@link UiValueChangeEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiValueChangeEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiValueChangeEvent) {
      onValueChange((UiValueChangeEvent) event);
    }
  }

  /**
   * @param event the {@link UiValueChangeEvent}.
   */
  void onValueChange(UiValueChangeEvent event);

}
