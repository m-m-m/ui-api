/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

/**
 * Abstract {@link UiTextualInput} with {@link String} {@link #getValue() value}.
 *
 * @since 1.0.0
 */
public abstract interface UiStringInput extends UiTextualInput<String> {

  @Override
  default String getText() {

    return getValue();
  }

  @Override
  default void setText(String text) {

    setValue(text);
  }

}
