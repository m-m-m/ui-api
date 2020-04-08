/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write the {@link #isCollapsed() collapsed} and {@link #isCollapsible() collapsible} flags.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteCollapsible {

  /**
   * @return {@code true} if this object is currently collapsed (minimized, hiding its details), {@code false} otherwise
   *         (if expanded).
   */
  boolean isCollapsed();

  /**
   * @param collapsed the new value of {@link #isCollapsed()}.
   */
  void setCollapsed(boolean collapsed);

  /**
   * @return {@code true} if this widget can be {@link #setCollapsed(boolean) collapsed and expanded} by the end-user
   *         (e.g. via some icon button), {@code false} otherwise.
   */
  boolean isCollapsible();

  /**
   * @param collapsible the new value of {@link #isCollapsible()}.
   */
  void setCollapsible(boolean collapsible);

}
