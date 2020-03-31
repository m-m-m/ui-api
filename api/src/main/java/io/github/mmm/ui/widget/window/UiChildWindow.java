/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.attribute.AttributeWriteClosable;
import io.github.mmm.ui.attribute.AttributeWriteMaximized;
import io.github.mmm.ui.attribute.AttributeWriteMinimized;
import io.github.mmm.ui.attribute.AttributeWriteMoveable;
import io.github.mmm.ui.attribute.AttributeWritePositionRange;
import io.github.mmm.ui.attribute.AttributeWriteSizeRange;

/**
 * {@link UiAbstractWindow} that is a child of another window.
 *
 * @since 1.0.0
 * @see UiMainWindow#isWindowPositionAbsolute()
 */
public abstract interface UiChildWindow extends UiAbstractWindow, AttributeWriteClosable, AttributeWriteMinimized,
    AttributeWriteMaximized, AttributeWriteMoveable {

  @Override
  AttributeWritePositionRange getPosition();

  @Override
  AttributeWriteSizeRange getSize();

  /**
   * Will modify the {@link #getPosition() position} such that the window is centered on the screen.
   */
  void centerOnScreen();

}
