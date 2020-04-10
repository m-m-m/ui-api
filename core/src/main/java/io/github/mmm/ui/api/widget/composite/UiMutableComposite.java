/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiComposite} that allows to {@link #addChild(UiWidget) add} and {@link #removeChild(UiWidget) remove} its
 * children dynamically with no additional arguments (e.g. layout information).
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public interface UiMutableComposite<C extends UiWidget> extends UiComposite<C> {

  /**
   * Adds the given {@code child} to the end of the {@link #getChild(int) child-list}. For vertical layouts this will be
   * the bottom and for horizontal layouts this will be the right.
   *
   * @see java.util.List#add(Object)
   *
   * @param child is the {@link UiWidget} to add as child of this composite.
   */
  default void addChild(C child) {

    addChild(child, -1);
  }

  /**
   * Inserts the given {@code child} at the given {@code index}.
   *
   * @see #addChild(UiWidget)
   * @see java.util.List#add(int, Object)
   *
   * @param child is the {@link UiWidget} to add as child of this composite.
   * @param index is the {@link #getChild(int) index} of the new child. It has to be in the range from {@code 0} to
   *        {@link #getChildCount()}.
   */
  void addChild(C child, int index);

  /**
   * This method removes the given <code>child</code> from this panel.
   *
   * @see java.util.List#remove(Object)
   *
   * @param child is the {@link UiWidget} to remove from this panel.
   * @return {@code true} if the given {@code child} has been removed successfully, {@code false} otherwise (no such
   *         child exists).
   */
  default boolean removeChild(C child) {

    int index = getChildIndex(child);
    if (index < 0) {
      return false;
    }
    removeChild(index);
    return true;
  }

  /**
   * This method removes the child at the given <code>index</code> from this panel.
   *
   * @see java.util.List#remove(int)
   *
   * @param index is the {@link #getChild(int) index} of the child to remove. It has to be in the range from
   *        <code>0</code> to <code>{@link #getChildCount()} - 1</code>.
   * @return the removed child that has previously been at the given <code>index</code>.
   */
  C removeChild(int index);

}
