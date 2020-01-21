/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.datatype.UiLength;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithClosable;
import io.github.mmm.ui.widget.attribute.UiWidgetWithMaximizable;
import io.github.mmm.ui.widget.attribute.UiWidgetWithPosition;
import io.github.mmm.ui.widget.attribute.UiWidgetWithSize;
import io.github.mmm.ui.widget.attribute.UiWidgetWithTitle;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} that represents a <em>window</em>. To open the window use {@link #setVisible(boolean)
 * setVisible(true)} and to close it use {@link #setVisible(boolean) setVisible(false)}. Some underlying UI toolkits do
 * not support to dynamically change the features of the window so configure them via {@link #setClosable(boolean)},
 * {@link #setResizable(boolean)}, etc. before opening the window.
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractWindow extends UiDynamicComposite<UiRegularWidget>, UiWidgetWithTitle,
    UiWidgetWithClosable, UiWidgetWithSize, UiWidgetWithPosition, UiWidgetWithMaximizable {

  /**
   * @return {@code true} if this window can be {@link #setSize(UiLength, UiLength) resized} by the end-user,
   *         {@code false} otherwise.
   */
  boolean isResizable();

  /**
   * @param resizable is the new value of {@link #isResizable()}.
   */
  void setResizable(boolean resizable);

  /**
   * @return {@code true} if this window can be moved by the end-user (by dragging around), {@code false} otherwise.
   */
  boolean isMovable();

  /**
   * @param movable is the new value of {@link #isMovable()}.
   */
  void setMovable(boolean movable);

}
