/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isCollapsed() read} and {@link #setCollapsed(boolean) write} the {@link #isCollapsed()
 * collapsed} flag.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteCollapsed {

  /**
   * @return {@code true} if this object is currently collapsed (minimized, hiding its details), {@code false} otherwise
   *         (if expanded).
   */
  boolean isCollapsed();

  /**
   * @param collapsed the new value of {@link #isCollapsed()}.
   */
  void setCollapsed(boolean collapsed);

}
