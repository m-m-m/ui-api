/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has a {@link #getText() text}.
 *
 * @since 1.0.0
 */
public interface UiWidgetWithText extends UiWidget {

  /**
   * @return the label or text of this widget. Will be the empty string if no text has been set. The text is permanently
   *         displayed on the widget as information for the user (e.g. to describe its meaning). For elements that allow
   *         to display or edit a value the text is typically shown beside the widget to view or edit the value. For
   *         action elements such as buttons or links this is the actual label text (lettering).
   */
  String getText();

  /**
   * @param text is the new {@link #getText() text} to set.
   */
  void setText(String text);

}
