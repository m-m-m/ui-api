/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write the {@link #isVisible() visibility}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteVisible extends AttributeReadVisible {

  /**
   * @param visible {@code true} to show this widget (in case its parent is also visible), {@code false} to hide this
   *        widget.
   * @see #isVisible()
   */
  void setVisible(boolean visible);

}
