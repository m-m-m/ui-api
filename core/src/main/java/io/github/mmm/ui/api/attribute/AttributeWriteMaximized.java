/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isMaximized() read} and {@link #setMaximized(boolean) write} the {@link #isMaximized() maximized
 * state}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteMaximized {

  /**
   * @return {@code true} if this widget is currently maximized (full-screen so its size covers the entire screen),
   *         {@code false} otherwise.
   */
  boolean isMaximized();

  /**
   * @param maximized {@code true} to maximize, {@code false} to un-maximize (size and position will be restored to the
   *        values before it was maximized).
   * @see #isMaximized()
   */
  void setMaximized(boolean maximized);

}
