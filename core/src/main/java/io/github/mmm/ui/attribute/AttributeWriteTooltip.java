/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read and write a {@link #getTooltip() tooltip}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteTooltip {

  /**
   * @return the text of this object. It is a brief description that explains this object to the end-user. Will be the
   *         empty {@link String} if no tooltip is specified.
   */
  String getTooltip();

  /**
   * @param tooltip is the new value of {@link #getTooltip()}.
   */
  void setTooltip(String tooltip);

}
