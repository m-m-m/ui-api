/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read and write an {@link #getAltText() alternative text}.
 *
 * @since 1.0.0
 */
public interface AttributeWriteAltText {

  /**
   * @return the <em>alternative text</em> of this object. This text is used to provide the essential information of an
   *         object in textual form. E.g. if an image can NOT be displayed because it is missing, the alternative text
   *         is displayed instead. Further, accessibility tools such as screen-readers can use this information to help
   *         the user in order to better understand the meaning of an object. Will be the empty {@link String} if not
   *         set.
   */
  String getAltText();

  /**
   * @param altText is the new {@link #getAltText() alternative text}.
   */
  void setAltText(String altText);

}
