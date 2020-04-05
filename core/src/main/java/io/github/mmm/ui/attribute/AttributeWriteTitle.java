/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read and write a {@link #getTitle() title}.
 *
 * @since 1.0.0
 */
public interface AttributeWriteTitle {

  /**
   * @return the title of this object. Similar to {@link AttributeWriteText#getText() text} but more exposed (e.g.
   *         displayed in title-bar in case of a {@link io.github.mmm.ui.widget.window.UiAbstractWindow window}). Will
   *         be the empty {@link String} if not set.
   */
  String getTitle();

  /**
   * @param title the new value of {@link #getTitle() title}.
   */
  void setTitle(String title);

}
