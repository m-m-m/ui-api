/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.window;

import io.github.mmm.ui.api.attribute.AttributeWriteClosable;
import io.github.mmm.ui.api.attribute.AttributeWriteMaximized;
import io.github.mmm.ui.api.attribute.AttributeWriteMinimized;
import io.github.mmm.ui.api.attribute.AttributeWriteMoveable;
import io.github.mmm.ui.api.attribute.AttributeWritePositionRange;
import io.github.mmm.ui.api.attribute.AttributeWriteSizeRange;

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
