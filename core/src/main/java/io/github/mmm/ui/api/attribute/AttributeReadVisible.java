/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isVisible() read} the {@link #isVisible() visibility}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadVisible {

  /**
   * @return {@code true} if visible, {@code false} if hidden.
   */
  boolean isVisible();

}
