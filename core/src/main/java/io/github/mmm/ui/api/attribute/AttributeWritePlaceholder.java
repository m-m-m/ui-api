/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getPlaceholder() read} and {@link #setPlaceholder(String) write} a {@link #getPlaceholder()
 * placeholder}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWritePlaceholder {

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
