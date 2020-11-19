/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getUrl() read} and {@link #setUrl(String) write} a {@link #getUrl() URL}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteUrl extends AttributeReadUrl {

  /**
   * @param url is the new {@link #getUrl() URL}.
   */
  void setUrl(String url);

}
