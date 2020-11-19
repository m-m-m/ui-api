/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getId() read} and {@link #setId(String) write} an {@link #getId() ID}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteId extends AttributeReadId {

  /**
   * Use this method to give the object a meaningful identifier after creation. <br>
   * <b>ATTENTION:</b><br>
   * See JavaDoc of {@link #getId()} for the syntax constraints of IDs.
   *
   * @param id is the new {@link #getId() ID} for the object.
   * @see #getId()
   */
  void setId(String id);

}
