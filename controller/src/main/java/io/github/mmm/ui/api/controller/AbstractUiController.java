/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import java.util.Objects;

import io.github.mmm.base.exception.ObjectMismatchException;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * Abstract base implementation of {@link UiController}.
 *
 * @param <W> type of the {@link #getView() view}.
 * @since 1.0.0
 */
public abstract class AbstractUiController<W extends UiWidget> implements UiController<W> {

  private UiControllerSlot slot;

  private W view;

  /**
   * The constructor.
   */
  public AbstractUiController() {

    super();
  }

  @Override
  public W getView() {

    if (this.view == null) {
      this.view = createView();
    }
    return this.view;
  }

  /**
   * @return the new instance of the {@link #getView() view}.
   */
  protected abstract W createView();

  /**
   * @return the {@link UiControllerSlot} of this controller.
   */
  protected UiControllerSlot getSlot() {

    return this.slot;
  }

  /**
   * Shows this controller (creates/updates and opens its {@link #getView() view}) as triggered by the given
   * {@link UiPlace}.
   *
   * @param newPlace the {@link UiPlace} {@link UiPlace#getId() identifying} this {@link UiController} and providing
   *        potential {@link UiPlace#getParameter(String) parameters}.
   * @return the {@link UiControllerSlot} where to embed this controller into a parent controller or {@code null} if
   *         this is the root controller.
   */
  public final UiControllerSlot show(UiPlace newPlace) {

    return show(newPlace, null);
  }

  /**
   * Shows this controller (creates/updates and opens its {@link #getView() view}) as triggered by the given
   * {@link UiPlace}.
   *
   * @param newPlace the {@link UiPlace} to open. It {@link UiPlace#getId() identifies} the leaf child
   *        {@link UiController} and provides potential {@link UiPlace#getParameter(String) parameters}.
   * @param newSlot the optional {@link UiControllerSlot} where to embed the child controller.
   * @return the {@link UiControllerSlot} where to embed this controller into a parent controller or {@code null} if
   *         this is the root controller.
   */
  public final UiControllerSlot show(UiPlace newPlace, UiControllerSlot newSlot) {

    Objects.requireNonNull(newPlace, "place");
    String expectedId;
    if (newSlot == null) {
      expectedId = newPlace.getId();
    } else {
      expectedId = newSlot.getId();
    }
    String controllerId = getId();
    if (!controllerId.equals(expectedId)) {
      throw new ObjectMismatchException(expectedId, controllerId);
    }
    onShow();
    this.slot = doShow(newPlace, newSlot);
    return this.slot;
  }

  /**
   * @param newPlace the {@link UiPlace} to open. It {@link UiPlace#getId() identifies} the leaf child
   *        {@link UiController} and provides potential {@link UiPlace#getParameter(String) parameters}.
   * @param newSlot the optional {@link UiControllerSlot} where to embed the child controller.
   * @return the {@link UiControllerSlot} where to embed this controller into a parent controller or {@code null} if
   *         this is the root controller.
   */
  protected abstract UiControllerSlot doShow(UiPlace newPlace, UiControllerSlot newSlot);

  @Override
  public boolean isVisible() {

    if (this.view != null) {
      return this.view.isVisible();
    }
    return false;
  }

  /**
   * This method resets this {@link AbstractUiController} and disposes its {@link #getView() view}.
   */
  protected final void reset() {

    onReset();
    if (this.view != null) {
      // this.view.removeFromParent();
      this.view.dispose();
    }
    this.view = null;
  }

  /**
   * This method gets called whenever this controller is {@link #reset() reseted}. If you keep custom state information
   * you need to override and reset your state.
   */
  protected void onReset() {

    // nothing to add...
  }

  /**
   * This method gets called whenever the {@link #getView() view} is shown on the screen. It can be overridden to
   * trigger custom logic - e.g. to update data.
   */
  protected void onShow() {

    // nothing by default...
  }

  /**
   * This method gets called whenever the {@link #getView() view} is hidden from the screen. It can be overridden to
   * trigger custom logics or to clean up resources.
   */
  protected void onHide() {

    // nothing by default...
  }

}
