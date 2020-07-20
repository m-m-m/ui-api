/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.navigation;

import io.github.mmm.ui.api.widget.composite.UiRemovableComposite;

/**
 * {@link UiRemovableComposite} that groups {@link UiAbstractMenuEntry menu entries}. It is either a {@link UiMenu} or
 * the {@link UiAbstractMenuBar top-level menu container itself}.
 *
 * @param <E> type of the {@link #getChild(int) child menu entries}.
 * @since 1.0.0
 */
public abstract interface UiAbstractMenu<E extends UiAbstractMenuEntry> extends UiRemovableComposite<E> {

  /**
   * @param text the new {@link UiMenu#getText() label text} of the {@link UiMenu} to create.
   * @return the {@link UiMenu} that has been created and added.
   */
  default UiMenu addMenu(String text) {

    return addMenu(text, -1);
  }

  /**
   * @param text the new {@link UiMenu#getText() label text} of the {@link UiMenu} to create.
   * @param index is the {@link #getChildIndex(io.github.mmm.ui.api.widget.UiWidget) index} where to insert the new
   *        {@link UiMenu}.
   * @return the {@link UiMenu} that has been created and added.
   */
  UiMenu addMenu(String text, int index);

}
