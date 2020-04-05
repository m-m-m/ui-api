/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read {@link #getSource() source}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadSource {

  /**
   * @return the source to external data. The value may be an absolute URL or a path relative to the current location
   *         (base URL).
   */
  String getSource();

}
