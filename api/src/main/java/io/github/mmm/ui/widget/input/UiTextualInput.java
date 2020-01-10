/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiRegularWidget;

/**
 * Abstract {@link UiRegularWidget} for textual input.
 */
public abstract interface UiTextualInput extends UiInput<String> {

  /**
   * @return {@code true} if this input widget is editable (value can be edited by the end-user similar if not
   *         {@link #isEnabled() enabled} but typically without visual differences such as grayed out), {@code false}
   *         otherwise.
   */
  boolean isEditable();

  /**
   * <b>ATTENTION:</b> {@link #isReadOnly() read-only} and {@link #isEditable() editable} are not independent states.
   * Setting to read-only and then setting to editable can have undesired effects. Therefore avoid to mix using both
   * states if possible.
   *
   * @param editable the new value of {@link #isEditable()}.
   */
  void setEditable(boolean editable);

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
