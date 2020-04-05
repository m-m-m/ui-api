/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

import io.github.mmm.ui.widget.window.UiMainWindow;

/**
 * Interface to {@link #isMovable() read} and {@link #setMovable(boolean) write} the {@link #isMovable() movable flag}.
 *
 * @since 1.0.0
 * @see UiMainWindow#isWindowPositionAbsolute()
 */
public abstract interface AttributeWriteMoveable {

  /**
   * @return {@code true} if this object can be {@link AttributeWritePosition#setPosition(double, double) moved} by the
   *         end-user (by dragging around), {@code false} otherwise.
   */
  boolean isMovable();

  /**
   * <b>ATTENTION:</b> Not all platforms may support changing this flag.
   * 
   * @param movable is the new value of {@link #isMovable()}.
   */
  void setMovable(boolean movable);

}
