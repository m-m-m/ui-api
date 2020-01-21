/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that can be {@link #click() clicked}.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetWithClick extends UiWidget {

  /**
   * This method {@link io.github.mmm.ui.event.UiEventListener#onEvent(io.github.mmm.ui.event.UiEvent) sends} a
   * {@link io.github.mmm.ui.event.UiEvent#isProgrammatic() programmatic} {@link io.github.mmm.ui.event.UiClickEvent} to
   * all {@link #addListener(io.github.mmm.ui.event.UiEventListener) registered}
   * {@link io.github.mmm.ui.event.UiEventListener}s.
   */
  void click();

}
