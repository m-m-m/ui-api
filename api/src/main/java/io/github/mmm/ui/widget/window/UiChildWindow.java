/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteMinimized;
import io.github.mmm.ui.attribute.AttributeWriteSize;
import io.github.mmm.ui.datatype.UiSize;
import io.github.mmm.ui.widget.attribute.UiWidgetWithClosable;

/**
 * {@link UiAbstractWindow} that is a child of another window.
 *
 * @since 1.0.0
 * @see UiMainWindow#isWindowPositionAbsolute()
 */
public abstract interface UiChildWindow
    extends UiAbstractWindow, UiWidgetWithClosable, AttributeWriteSize, AttributeWriteMinimized {

  @Override
  default double getWidthInPixel() {

    UiContext context = getContext();
    UiMainWindow mainWindow = context.getMainWindow();
    UiSize width = getWidth();
    if (mainWindow.isWindowPositionAbsolute()) {
      return width.toPixel(context.getScreen().getWidthInPixel());
    } else {
      return width.toPixel(mainWindow.getWidthInPixel());
    }
  }

  @Override
  default double getHeightInPixel() {

    UiContext context = getContext();
    UiMainWindow mainWindow = context.getMainWindow();
    UiSize height = getHeight();
    if (mainWindow.isWindowPositionAbsolute()) {
      return height.toPixel(context.getScreen().getHeightInPixel());
    } else {
      return height.toPixel(mainWindow.getHeightInPixel());
    }
  }

  /**
   * @return {@code true} if this window can be moved by the end-user (by dragging around), {@code false} otherwise.
   */
  boolean isMovable();

  /**
   * @param movable is the new value of {@link #isMovable()}.
   */
  void setMovable(boolean movable);

}
