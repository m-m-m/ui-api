/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * {@link UiWidget} that is <em>active</em> so it can be {@link #setFocused() focused} and allows to
 * {@link #setAccessKey(char) assign an access-key}. If a {@link UiComposite} is active it will delegate focus and
 * access-key to the first active child.
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

}
