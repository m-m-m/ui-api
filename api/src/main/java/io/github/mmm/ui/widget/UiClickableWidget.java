/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

/**
 * {@link UiActiveWidget} that has a {@link #getLabel() label} and is {@link #click() clickable}.
 *
 * @since 1.0.0
 */
public abstract interface UiClickableWidget extends UiActiveWidget, UiLabelledWidget {

  /**
   * This method {@link io.github.mmm.ui.event.UiEventListener#onEvent(io.github.mmm.ui.event.UiEvent) sends} a
   * {@link io.github.mmm.ui.event.UiEvent#isProgrammatic() programmatic} {@link io.github.mmm.ui.event.UiClickEvent} to
   * all {@link #addListener(io.github.mmm.ui.event.UiEventListener) registered}
   * {@link io.github.mmm.ui.event.UiEventListener}s.
   */
  void click();

}
