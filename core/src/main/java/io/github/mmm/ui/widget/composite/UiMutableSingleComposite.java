/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiSingleComposite} that is mutable and allows to {@link #setChild(UiWidget) set its child widget}.
 *
 * @param <C> type of the {@link #getChild(int) child}.
 * @since 1.0.0
 */
public abstract interface UiMutableSingleComposite<C extends UiWidget> extends UiSingleComposite<C> {

  /**
   * @param child the new {@link #getChild() child widget}.
   */
  void setChild(C child);

}
