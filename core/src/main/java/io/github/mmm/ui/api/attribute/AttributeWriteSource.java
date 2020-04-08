/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read and write a {@link #getSource() source}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteSource extends AttributeReadSource {

  /**
   * @param source is the new {@link #getSource() source}.
   */
  void setSource(String source);

}
