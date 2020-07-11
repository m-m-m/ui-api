/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isEnabled() read} the {@link #isEnabled() enabled flag} of an object.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadEnabled {

  /**
   * @return {@code true} if enabled, {@code false} if disabled (end-user cannot interact with this widget or its
   *         children and active widgets are visually grayed out).
   */
  boolean isEnabled();
}
