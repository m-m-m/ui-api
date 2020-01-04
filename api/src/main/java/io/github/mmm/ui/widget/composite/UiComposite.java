/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.datatype.UiPropagation;
import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that is {@link #getChild(int) composed out of child widgets}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract interface UiComposite<C extends UiWidget> extends UiWidget {

  /**
   * @return the number of direct children contained in this widget.
   */
  int getChildCount();

  /**
   * @param index is the index of the requested child. Should be in the range from {@code 0} to
   *        <code>{@link #getChildCount()} - 1</code>.
   * @return the requested child or {@code null} if no such child exists.
   * @see java.util.List#get(int)
   */
  C getChild(int index);

  /**
   * @param child the {@link #getChild(int) child} to look for.
   * @return the index of the given {@code child} or {@code -1} if no such {@link #getChild(int) child} exists.
   */
  int getChildIndex(C child);

  /**
   * @param id is the {@link #getId() ID} of the requested {@link #getChild(int) child}.
   * @return the {@link #getChild(int) child} with the given {@code id} or {@code null} if no such {@link #getChild(int)
   *         child} exists.
   * @see #getDescendant(String)
   */
  default C getChild(String id) {

    int size = getChildCount();
    for (int i = 0; i < size; i++) {
      C child = getChild(i);
      if (id.equals(child.getId())) {
        return child;
      }
    }
    return null;
  }

  /**
   * @param id is the {@link #getId() ID} of the requested {@link #getChild(int) child} or descendant (recursive child
   *        of children).
   * @return the {@link #getChild(int) child} or descendant (recursive child of children) with the given {@code id} or
   *         {@code null} if no such {@link #getChild(int) child} exists.
   * @see #getChild(String)
   */
  default UiWidget getDescendant(String id) {

    int size = getChildCount();
    for (int i = 0; i < size; i++) {
      C child = getChild(i);
      if (id.equals(child.getId())) {
        return child;
      } else if (child instanceof UiComposite<?>) {
        UiWidget descendant = ((UiComposite<?>) child).getChild(id);
        if (descendant != null) {
          return descendant;
        }
      }
    }
    return null;
  }

  /**
   * @return the {@link UiPropagation} indicating which properties of this {@link UiComposite} are propagated to the
   *         {@link #getChild(int) children}. A composite might be fully virtual and do not have a corresponding native
   *         widget. In such case it would return {@link UiPropagation#ALL} and if it get hidden or disabled, it has to
   *         propagate such state changes to their children.
   */
  default UiPropagation getPropagation() {

    return UiPropagation.NONE;
  }

}
