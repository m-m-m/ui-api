/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

/**
 * {@link UiWidget} that has a label.
 *
 * @since 1.0.0
 */
public interface UiLabelledWidget extends UiWidget {

  /**
   * @return the label text of this widget. Will be the empty string if no label has been set. A label is some text that
   *         is permanently displayed on the widget in order to describe its meaning. For elements that allow to display
   *         or edit a value the label is typically shown beside the edit/display widget. For action elements such as
   *         buttons or links the label is the actual text (lettering).
   */
  String getLabel();

  /**
   * @param label is the new {@link #getLabel() label} to set.
   */
  void setLabel(String label);

}
