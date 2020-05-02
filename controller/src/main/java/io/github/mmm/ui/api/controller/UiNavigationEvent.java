/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.ui.api.attribute.AttributeReadProgrammatic;

/**
 * Event for {@link UiNavigationManager#navigateTo(UiPlace) navigation}.
 *
 * @since 1.0.0
 */
public class UiNavigationEvent implements AttributeReadProgrammatic {

  private final UiPlace oldPlace;

  private final UiPlace newPlace;

  private final boolean programmatic;

  /**
   * The constructor.
   *
   * @param oldPlace the {@link #getOldPlace() old place}.
   * @param newPlace the {@link #getNewPlace() new place}.
   * @param programmatic the {@link #isProgrammatic() programmatic flag}.
   */
  public UiNavigationEvent(UiPlace oldPlace, UiPlace newPlace, boolean programmatic) {

    super();
    this.oldPlace = oldPlace;
    this.newPlace = newPlace;
    this.programmatic = programmatic;
  }

  /**
   * @return the old (previous) {@link UiPlace} that was left during the navigation. The very first navigation event
   *         will use {@link UiPlace#NONE}.
   */
  public UiPlace getOldPlace() {

    return this.oldPlace;
  }

  /**
   * @return the new {@link UiPlace} that was entered during the navigation.
   */
  public UiPlace getNewPlace() {

    return this.newPlace;
  }

  @Override
  public boolean isProgrammatic() {

    return this.programmatic;
  }

}
