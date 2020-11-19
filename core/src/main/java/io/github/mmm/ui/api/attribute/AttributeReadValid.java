/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isValid() read} the {@link #isValid() valid flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadValid {

  /**
   * @return {@code true} if valid (no {@link AttributeWriteValidationFailure#getValidationFailure() validation failure}
   *         is present), {@code false} otherwise.
   */
  boolean isValid();

}
