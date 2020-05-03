/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.ui.api.attribute.AttributeReadId;

/**
 * A {@link UiControllerSlot} represents a location within the {@link UiController#getView() view} of a
 * {@link UiController} where a sub-dialog can be embedded.
 *
 * @since 1.0.0
 */
public class UiControllerSlot implements AttributeReadId {

  /** {@link UiControllerSlot} for the {@link UiController#TYPE_PAGE page} controller. */
  public static final UiControllerSlot SLOT_ROOT = new UiControllerSlot(UiController.ID_ROOT,
      UiController.TYPE_PAGE);

  /** {@link UiControllerSlot} for the {@link UiController#TYPE_MAIN main} controller. */
  public static final UiControllerSlot SLOT_PAGE_MAIN = new UiControllerSlot(UiController.ID_PAGE,
      UiController.TYPE_MAIN);

  /** {@link UiControllerSlot} for the {@link UiController#TYPE_NAVIGATION navigation} controller. */
  public static final UiControllerSlot SLOT_NAVIGATION = new UiControllerSlot(UiController.ID_NAVIGATION,
      UiController.TYPE_NAVIGATION);

  private final String id;

  private final String slot;

  /**
   * The constructor.
   *
   * @param id the {@link #getId() ID}.
   * @param slot the {@link #getSlot() slot}.
   */
  public UiControllerSlot(String id, String slot) {

    super();
    this.id = id;
    this.slot = slot;
  }

  /**
   * @return the {@link UiController#getId() ID} of the {@link UiController}.
   */
  @Override
  public final String getId() {

    return this.id;
  }

  /**
   * @return the ID of the slot.
   */
  public String getSlot() {

    return this.slot;
  }

  @Override
  public String toString() {

    return this.slot + "@" + this.id;
  }

}
