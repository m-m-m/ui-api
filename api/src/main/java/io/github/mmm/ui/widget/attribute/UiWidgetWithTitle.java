/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #getTitle() title}.
 *
 * @since 1.0.0
 */
public interface UiWidgetWithTitle extends UiWidget {

  /**
   * @return the title of this widget. Similar to {@link UiWidgetWithText#getText() label} but more exposed (e.g.
   *         displayed in title-bar in case of a {@link io.github.mmm.ui.widget.window.UiWindow window}). Will be the
   *         empty {@link String} if not set.
   */
  String getTitle();

  /**
   * @param title the new value of {@link #getTitle() title}.
   */
  void setTitle(String title);

}
