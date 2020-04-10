/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link AbstractUiController} with {@link #getType() type} {@link UiController#TYPE_MAIN main}.
 *
 * @param <W> type of the {@link #getView() view}.
 * @since 1.0.0
 */
public abstract class AbstractUiControllerMain<W extends UiRegularWidget> extends AbstractUiController<W> {

  @Override
  public String getType() {

    return TYPE_MAIN;
  }

  @Override
  protected UiControllerSlot doShow(UiPlace newPlace, UiControllerSlot newSlot) {

    return UiControllerSlot.SLOT_PAGE_MAIN;
  }

}
