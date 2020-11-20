/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.datatype.UiPropagation;
import io.github.mmm.ui.api.widget.UiWidget;

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
   * @param child the current {@link #getChild(int) child}.
   * @param offset the sibling offset - e.g. {@code 1} will get next sibling and {@code -1} will get previous sibling.
   * @return the requested child sibling or {@code null} if no such child exists.
   */
  default C getChildSibling(C child, int offset) {

    return getChildSibling(child, offset, true);
  }

  /**
   * @param child the current {@link #getChild(int) child}.
   * @param offset the sibling offset - e.g. {@code 1} will get next sibling and {@code -1} will get previous sibling.
   * @param wrap - {@code true} to wrap in the list of children (jump from the last to the first and vice versa),
   *        {@code false} otherwise (to return {@code null} if the end or the start of the children has been exceeded).
   * @return the requested child sibling or {@code null} if no such child exists.
   */
  default C getChildSibling(C child, int offset, boolean wrap) {

    int i = getChildIndex(child);
    if (i < 0) {
      return null;
    }
    int size = getChildCount();
    if (wrap && (size == 1)) {
      return child;
    }
    i = i + offset;
    if (wrap) {
      if (i < 0) {
        i = i + size;
      } else if (i >= size) {
        i = i - size;
      }
    }
    return getChild(i);
  }

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
   *         widget. In such case it would return {@link UiPropagation#VISIBLE_AND_ENABLED} and if it get hidden or
   *         disabled, it has to propagate such state changes to their children.
   */
  default UiPropagation getPropagation() {

    return UiPropagation.NONE;
  }

  @Override
  default boolean setFocused() {

    int childCount = getChildCount();
    for (int i = 0; i < childCount; i++) {
      C child = getChild(i);
      if (child.setFocused()) {
        return true;
      }
    }
    return false;
  }

  @Override
  default boolean isModified() {

    int childCount = getChildCount();
    for (int i = 0; i < childCount; i++) {
      C child = getChild(i);
      if (child.isModified()) {
        return true;
      }
    }
    return false;
  }

  @Override
  default long getModificationTimestamp() {

    long modificationTimestamp = -1;
    int childCount = getChildCount();
    for (int i = 0; i < childCount; i++) {
      C child = getChild(i);
      long ts = child.getModificationTimestamp();
      if (ts > modificationTimestamp) {
        ts = modificationTimestamp;
      }
    }
    return modificationTimestamp;
  }

  @Override
  default boolean isValid() {

    int childCount = getChildCount();
    for (int i = 0; i < childCount; i++) {
      C child = getChild(i);
      if (!child.isValid()) {
        return false;
      }
    }
    return true;
  }

  @Override
  default void reset() {

    UiWidget.super.reset();
    int childCount = getChildCount();
    for (int i = 0; i < childCount; i++) {
      C child = getChild(i);
      child.reset();
    }

  }

}
