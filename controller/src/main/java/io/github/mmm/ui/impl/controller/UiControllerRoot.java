/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.controller;

import io.github.mmm.ui.api.controller.AbstractUiController;
import io.github.mmm.ui.api.controller.UiControllerSlot;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.widget.window.UiMainWindow;

/**
 * {@link io.github.mmm.ui.api.controller.UiController} with {@link #getType() type}
 * {@link io.github.mmm.ui.api.controller.UiController#ID_ROOT root}.
 */
public class UiControllerRoot extends AbstractUiController<UiMainWindow> {

  @Override
  public String getId() {

    return ID_ROOT;
  }

  @Override
  public String getTitle() {

    // This title will never be displayed...
    return ID_ROOT;
  }

  @Override
  public String getType() {

    return TYPE_ROOT;
  }

  @Override
  protected UiMainWindow createView() {

    return UiMainWindow.get();
  }

  @Override
  protected UiControllerSlot doShow(UiPlace newPlace, UiControllerSlot newSlot) {

    return null;
  }

}
