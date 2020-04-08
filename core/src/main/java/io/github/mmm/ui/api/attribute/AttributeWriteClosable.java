/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isClosable() read} and {@link #setClosable(boolean) write} the {@link #isClosable() closable
 * flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteClosable {

  /**
   * @return {@code true} if this object is closable (the end-user can close it e.g. via an icon-button), {@code false}
   *         otherwise.
   */
  boolean isClosable();

  /**
   * @param closable is the new value of {@link #isClosable()}.
   */
  void setClosable(boolean closable);

}
