/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

/**
 * A {@link UiEmbedding} represents a location within the {@link UiController#getView() view} of a {@link UiController}
 * where a sub-dialog shall be {@link UiController#embed(UiEmbedding, UiController) embedded}.
 *
 * @since 1.0.0
 * @see UiController#embed(UiEmbedding, UiController)
 */
public class UiEmbedding {

  /** {@link UiEmbedding} for the {@link UiController#ID_PAGE page} {@link UiController}. */
  public static final UiEmbedding PAGE = new UiEmbedding(UiController.ID_ROOT, UiController.ID_PAGE);

  /** {@link UiEmbedding} for the {@link UiController#ID_HEADER header} {@link UiController}. */
  public static final UiEmbedding HEADER = new UiEmbedding(UiController.ID_PAGE, UiController.ID_HEADER);

  /** {@link UiEmbedding} for the {@link UiController#ID_FOOTER footer} {@link UiController}. */
  public static final UiEmbedding FOOTER = new UiEmbedding(UiController.ID_PAGE, UiController.ID_FOOTER);

  /** {@link UiEmbedding} for the {@link UiController#ID_NAVIGATION navigation} {@link UiController}. */
  public static final UiEmbedding NAVIGATION = new UiEmbedding(UiController.ID_PAGE, UiController.ID_NAVIGATION);

  /** {@link UiEmbedding} for the {@link UiController#ID_CONTENT footer} {@link UiController}. */
  public static final UiEmbedding CONTENT = new UiEmbedding(UiController.ID_PAGE, UiController.ID_CONTENT);

  /** {@link UiEmbedding} for the {@link UiController#ID_MARGIN margin column} {@link UiController}. */
  public static final UiEmbedding MARGIN = new UiEmbedding(UiController.ID_PAGE, UiController.ID_MARGIN);

  /** {@link UiEmbedding} for the {@link UiController#ID_HOME home} {@link UiController}. */
  public static final UiEmbedding HOME = new UiEmbedding(UiController.ID_CONTENT, UiController.ID_HOME);

  private final String controllerId;

  private final String slotId;

  /**
   * The constructor.
   *
   * @param controllerId the {@link #getControllerId() controller ID}.
   * @param slotId the {@link #getSlotId() slot ID}.
   */
  public UiEmbedding(String controllerId, String slotId) {

    super();
    this.controllerId = controllerId;
    this.slotId = slotId;
  }

  /**
   * @return the {@link UiController#getId() ID} of the {@link UiController} owning the {@link #getSlotId() referenced
   *         slot}.
   */
  public final String getControllerId() {

    return this.controllerId;
  }

  /**
   * @return the ID of the <em>slot</em> where to {@link UiController#embed(UiEmbedding, UiController) embed}. The name
   *         slot refers to {@link io.github.mmm.ui.api.widget.composite.UiSlot} that is a dedicated widget for generic
   *         embedding. However, any composite widget may be used as slot to embed child views.
   */
  public String getSlotId() {

    return this.slotId;
  }

  @Override
  public String toString() {

    return this.slotId + "@" + this.controllerId;
  }

}
