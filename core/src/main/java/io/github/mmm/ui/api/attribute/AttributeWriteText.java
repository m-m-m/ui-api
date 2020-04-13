/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.input.UiComboBox;

/**
 * {@link UiWidget} that has a {@link #getText() text}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteText {

  /**
   * @return the label or text of this widget. Will be the empty string if no text has been set. If used as label the
   *         text is permanently displayed as information for the user to describe its meaning (lettering for button or
   *         label). Otherwise for textual inputs the text is the plain {@link AttributeReadValue#getValue() value} as
   *         text entered by the end-user. If the {@link AttributeReadValue#getValue() value} type is not {@link String}
   *         (e.g. for {@link UiComboBox}) this gives direct access to the plain text entered by the end-user (even in
   *         case it is not a valid option). This can be useful in a combo-box in case
   *         {@link AttributeReadValue#getValue() value} is undefined to accept the text as a new option (e.g. for a
   *         tag).
   */
  String getText();

  /**
   * @param text is the new {@link #getText() text} to set.
   */
  void setText(String text);

}
