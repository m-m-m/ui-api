/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiComposite} that allows to {@link #addChild(UiWidget) add} and {@link #removeChild(UiWidget) remove} its
 * children dynamically.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public interface UiMutableComposite<C extends UiWidget> extends UiRemovableComposite<C> {

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

}
