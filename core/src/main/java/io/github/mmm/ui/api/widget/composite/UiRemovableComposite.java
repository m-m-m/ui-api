/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiComposite} that allows to {@link #removeChild(UiWidget) remove} its children dynamically.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public interface UiRemovableComposite<C extends UiWidget> extends UiComposite<C> {

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
