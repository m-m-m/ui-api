/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

/**
 * This is the interface for a {@link UiRegularWidget regular widget} that can be {@link #setFocused() focused} and
 * allows to {@link #setAccessKey(char) assign an access-key}.
 *
 * @since 1.0.0
 */
public interface UiActiveWidget extends UiWidget {

  /** The {@link #getAccessKey() access key} value if no access key is defined. */
  char ACCESS_KEY_NONE = '\0';

  /**
   * @return the <em>access key</em> of this widget. If the access key is pressed together with the [shift] and [alt]
   *         keys this widget will be <em>invoked</em> means that it is clicked. If not an action item (button, link,
   *         etc.) it will get the {@link #isFocused() focus}. Will be {@link #ACCESS_KEY_NONE} if no access key is
   *         defined.
   */
  char getAccessKey();

  /**
   * This method sets the {@link #getAccessKey() accessKey} attribute of this object.
   *
   * @param accessKey is the new value of {@link #getAccessKey()}. Use {@link #ACCESS_KEY_NONE} to unset.
   */
  void setAccessKey(char accessKey);

  /**
   * @return {@code true} if this widget currently has the focus (the cursor is placed in the widget e.g. a text input
   *         and it will receive keyboard events), {@code false} otherwise.
   */
  boolean isFocused();

  /**
   * This method sets the {@link #isFocused() focus} to this widget. <br>
   * <b>NOTE:</b><br>
   * You can only set the focus. To actually remove it, you need to set it in a different widget.
   *
   * @return {@code true} if the focus has been set successfully, {@code false} otherwise. You can normally ignore the
   *         result. It is only relevant for composite widgets such as panels, that delegate the call recursively and
   *         may not contain any child that can take the focus.
   */
  boolean setFocused();

}
