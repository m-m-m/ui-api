/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.dialog;

import java.util.Map;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * Abstract base implementation of {@link Dialog}.
 *
 * @since 1.0.0
 */
public abstract class DialogController<W extends UiWidget> implements Dialog {

  /** @see #setSubDialog(DialogController, DialogSlot, DialogPlace) */
  private Map<String, DialogController<?>> slotMap;

  private W view;

  /**
   * The constructor.
   */
  public DialogController() {

    super();
  }

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
   * This method resets this {@link DialogController} and disposes its {@link #getView() view}.
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
