/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getText() read} and {@link #setText(String) write} the {@link #getText() text}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteText extends AttributeReadText {

  /**
   * @param text is the new {@link #getText() text} to set.
   */
  void setText(String text);

}
