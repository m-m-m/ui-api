/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} with a {@link #getTooltip() toopltip}.
 *
 * @since 1.0.0
 */
public abstract interface UiWidgetWithTooltip extends UiWidget {

  /**
   * @return the text of this widget. It is a brief description that explains this widget to the end-user. Will be the
   *         empty {@link String} if no tooltip is specified.
   */
  String getTooltip();

  /**
   * @param tooltip is the new {@link #getTooltip() tooltip}.
   */
  void setTooltip(String tooltip);

}
