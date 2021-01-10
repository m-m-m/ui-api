/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.window;

import io.github.mmm.ui.api.attribute.AttributeReadPosition;
import io.github.mmm.ui.api.attribute.AttributeReadSize;
import io.github.mmm.ui.api.attribute.AttributeWriteResizable;
import io.github.mmm.ui.api.attribute.AttributeWriteTitle;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * {@link UiMutableComposite} that represents a <em>window</em>.
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractWindow
    extends UiMutableComposite<UiRegularWidget>, AttributeWriteTitle, AttributeWriteResizable {

  @Override
  UiAbstractWindow getParent();

  /**
   * @param window is the potential descendant of this window. May be {@code null}.
   * @return the ancestor of the given {@link UiChildWindow} that has this window as parent. Will be {@code null} if no
   *         such window was found (the given {@link UiChildWindow} is {@code null} or not a descendant of this window).
   */
  default UiAbstractWindow findChild(UiChildWindow window) {

    if (window == null) {
      return null;
    }
    UiAbstractWindow current = window;
    while (current != null) {
      UiAbstractWindow currentParent = current.getParent();
      if (currentParent == this) {
        return current;
      }
      current = currentParent;
    }
    return null;
  }

  /**
   * @return access to read and write the position of this window.
   */
  AttributeReadPosition getPosition();

  /**
   * @return access to read and write the size of this window.
   */
  AttributeReadSize getSize();

  /**
   * Opens this window by setting {@link #isVisible() visible} to {@code true}.
   */
  default void open() {

    setVisible(true);
  }

  /**
   * Opens this window by setting {@link #isVisible() visible} to {@code false}.
   */
  default void close() {

    setVisible(false);
  }

}
