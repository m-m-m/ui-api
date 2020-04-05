/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.event.action.UiActionClose;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.panel.UiButtonPanel;

/**
 * {@link UiAbstractWindow} representing a modal popup window that blocks the client application until it is
 * {@link #setVisible(boolean) closed}. <br>
 * <b>NOTE:</b><br>
 * You typically want to call {@link #createAndAddCloseButton()}. This is not done automatically so you can define the
 * order of the buttons yourself.
 *
 * @since 1.0.0
 */
public interface UiPopup extends UiChildWindow, UiNativeWidget {

  /**
   * @return the {@link UiButtonPanel} located at the bottom of this popup where {@link UiButton buttons} shall be
   *         added.
   */
  UiButtonPanel getButtonPanel();

  /**
   * This method creates a {@link UiButton button} to close this popup and adds it to the {@link #getButtonPanel()
   * button panel}.
   *
   * @return the close button.
   */
  default UiButton createAndAddCloseButton() {

    UiActionClose close = (e) -> setVisible(false);
    UiButton closeButton = UiButton.of(getContext(), close);
    getButtonPanel().addChild(closeButton);
    return closeButton;

  }

}
