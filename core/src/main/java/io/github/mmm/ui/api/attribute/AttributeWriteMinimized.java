/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and {@link #setMinimized(boolean) write} the {@link #isMinimized() minimized} state.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteMinimized {

  /**
   * @return {@code true} if this object (window) is currently minimized (iconified, hidden to taskbar), {@code false}
   *         otherwise.
   */
  boolean isMinimized();

  /**
   * @param minimized {@code true} to {@link #isMinimized() minimize}, {@code false} to normalize (size and position
   *        will be restored to the values before it was minimized).
   * @see #isMinimized()
   */
  void setMinimized(boolean minimized);

}
