/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

import io.github.mmm.ui.api.attribute.AttributeReadProgrammatic;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * This is the interface for an event of the UI.
 *
 * @since 1.0.0
 */
public abstract class UiEvent implements AttributeReadProgrammatic {

  private final UiWidget source;

  private boolean programmatic;

  /**
   * The constructor.
   *
   * @param source the {@link #getSource() source widget}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiEvent(UiWidget source, boolean programmatic) {

    super();
    this.source = source;
    this.programmatic = programmatic;
  }

  /**
   * @return the source object (widget) that sent this event.
   */
  public UiWidget getSource() {

    return this.source;
  }

  @Override
  public boolean isProgrammatic() {

    return this.programmatic;
  }

  /**
   * @return the type of this event.
   * @see UiEventType
   */
  public abstract UiEventType getType();

}
