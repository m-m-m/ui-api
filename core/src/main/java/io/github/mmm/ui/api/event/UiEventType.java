/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event;

/**
 * Type of a {@link UiEvent}. Simple wrapper for a {@link String}. Using an {@link Enum} would prevent extending with
 * custom events. Using a plain {@link String} might cause issues with code checkers when comparing for identity.
 *
 * @see UiClickEvent#TYPE
 * @see UiFocusGainEvent#TYPE
 * @see UiFocusLossEvent#TYPE
 * @see UiHideEvent#TYPE
 * @see UiShowEvent#TYPE
 * @see UiValueChangeEvent#TYPE
 * @since 1.0.0
 */
public final class UiEventType {

  private final String name;

  /**
   * The constructor.
   *
   * @param name the name.
   */
  public UiEventType(String name) {

    super();
    this.name = name;
  }

  @Override
  public String toString() {

    return this.name;
  }

}
