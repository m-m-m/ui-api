/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiMutableComposite} that only shows a single {@link #getChild(int) child} at a time. You can
 * {@link #setActiveChild(UiWidget) switch} the active (visible) {@link #getChild(int) child} programmatically.
 *
 * @param <C> is the generic type of the {@link #getChild(int) children}.
 * @since 1.0.0
 */
public abstract interface UiSwitchComposite<C extends UiWidget> extends UiMutableComposite<C> {

  /**
   * @return the {@link #getChild(int) index} of the child that is currently active (visible). Will be {@code -1} if no
   *         child is active.
   */
  int getActiveChildIndex();

  /**
   * @return the active child (that is currently visible) or {@code null} if no child is currently active.
   */
  default C getActiveChild() {

    return getChild(getActiveChildIndex());
  }

  /**
   * @param index is the {@link #getChild(int) index} of the child to set active (show). It should be in the range from
   *        {@code 0} to <code>{@link #getChildCount()} - 1</code>.
   */
  default void setActiveChildIndex(int index) {

    setActiveChild(getChild(index));
  }

  /**
   * @param child is the {@link #getChild(int) child} to set active (show).
   * @return {@code true} if the given {@code child} was found and set active (shown), {@code false} otherwise.
   */
  boolean setActiveChild(C child);

  /**
   * @param id is the {@link #getId() ID} of the requested child.
   * @return <code>true</code> if the {@link #getChild(int) child} with the given <code>id</code> was found and shown,
   *         <code>false</code> if there is no such {@link #getChild(int) child} in this composite.
   */
  default boolean setActiveChildId(String id) {

    return setActiveChild(getChild(id));
  }

}
