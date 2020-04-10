/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write a {@link #getTitle() title}.
 *
 * @since 1.0.0
 */
public interface AttributeReadTitle {

  /**
   * @return the title of this object. Similar to {@link AttributeWriteText#getText() text} but more exposed (e.g.
   *         displayed in title-bar in case of a window). Will be the empty {@link String} if not set.
   */
  String getTitle();

}
