/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiEvent} for a change of the focus.
 *
 * @see io.github.mmm.ui.api.widget.UiActiveWidget#setFocused()
 * @since 1.0.0
 */
public abstract class UiFocusEvent extends UiEvent {

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiFocusEvent(UiWidget source, boolean programmatic) {

    super(source, programmatic);
  }

}
