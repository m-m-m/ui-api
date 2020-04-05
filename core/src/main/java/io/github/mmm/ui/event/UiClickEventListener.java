/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.event;

/**
 * {@link UiEventListener} for {@link UiClickEvent}s.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiClickEventListener extends UiEventListener {

  @Override
  default void onEvent(UiEvent event) {

    if (event instanceof UiClickEvent) {
      onClick((UiClickEvent) event);
    }
  }

  /**
   * @param event the {@link UiClickEvent}.
   */
  void onClick(UiClickEvent event);

}
