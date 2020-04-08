/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.attribute.AttributeWriteAutocomplete;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * Abstract {@link UiRegularWidget} for textual input.
 *
 * @param <V> type of the {@link #getValue() value}. Typically {@link String}.
 * @since 1.0.0
 */
public abstract interface UiTextualInput<V> extends UiInput<V>, AttributeWriteAutocomplete {

  /**
   * @return the plain text entered by the end-user. Most likely the same as {@link #getValue() value} but if the value
   *         type is not {@link String} (e.g. for {@link UiComboBox}) this gives direct access to the {@link String} as
   *         entered by the end-user (even in case it is not a valid option). This can be useful in a combo-box in case
   *         {@link #getValue() value} is undefined to accept the text as a new option (e.g. for a tag).
   */
  String getText();

  /**
   * @param text the raw {@link #getText() text} to enter into this widget.
   */
  void setText(String text);

  /**
   * @return the placeholder text that is displayed if the input text field is blank. Will be the empty string if not
   *         set.
   */
  String getPlaceholder();

  /**
   * @param placeholder the new value of {@link #getPlaceholder()}.
   */
  void setPlaceholder(String placeholder);

}
