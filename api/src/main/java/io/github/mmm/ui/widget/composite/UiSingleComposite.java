/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import java.util.Objects;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiComposite} that contains a single {@link #getChild() child}.
 *
 * @param <C> type of the {@link #getChild(int) child}.
 * @since 1.0.0
 */
public interface UiSingleComposite<C extends UiWidget> extends UiComposite<C> {

  /**
   * This method gets the single {@link #getChild(int) child} of this composite.
   *
   * @return the single child or {@code null} if not set.
   */
  C getChild();

  @Override
  default C getChild(int index) {

    if (index == 0) {
      return getChild();
    }
    return null;
  }

  /**
   * @return {@code 0} if {@link #getChild()} is {@code null}, {@code 1} otherwise.
   */
  @Override
  default int getChildCount() {

    if (getChild() != null) {
      return 1;
    }
    return 0;
  }

  @Override
  default int getChildIndex(C child) {

    if (child == getChild()) {
      return 0;
    }
    return -1;
  }

  @Override
  default C getChild(String id) {

    C child = getChild();
    if ((child != null) && (Objects.equals(child.getId(), id))) {
      return child;
    }
    return null;
  }

}
