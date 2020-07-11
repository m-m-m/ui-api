/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isEnabled() read} and {@link #setEnabled(boolean) write} the {@link #isEnabled() enabled flag}
 * of an object.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteEnabled extends AttributeReadEnabled {

  /**
   * @param enabled the new {@link #isEnabled() enabled state}. Use {@code true} to enable and {@code false} to disable
   *        this widget.
   */
  void setEnabled(boolean enabled);
}
