/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read the {@link #isValid() valid flag}.
 *
 * @since 1.0.0
 */
public interface AttributeReadValid {

  /**
   * @return {@code true} if valid (no {@link AttributeWriteValidationFailure#getValidationFailure() validation failure}
   *         is present), {@code false} otherwise.
   */
  boolean isValid();

}
