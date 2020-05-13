/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read a {@link #getUrl() URL}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadUrl {

  /**
   * @return the source to external data as URL or URI.
   */
  String getUrl();

}
