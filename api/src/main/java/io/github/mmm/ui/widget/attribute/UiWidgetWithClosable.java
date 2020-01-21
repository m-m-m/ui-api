/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #isClosable() closable} property to configure if it can be closed by the end-user.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetWithClosable extends UiWidget {

  /**
   * @return {@code true} if this widget is closable (the end-user can close this widget e.g. via an icon-button),
   *         {@code false} otherwise.
   */
  boolean isClosable();

  /**
   * @param closable is the new value of {@link #isClosable()}.
   */
  void setClosable(boolean closable);

}
