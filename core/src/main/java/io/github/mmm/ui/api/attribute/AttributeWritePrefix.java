/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getPrefix() read} and {@link #setPrefix(String) write} a {@link #getPrefix() prefix}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWritePrefix {

  /**
   * @return the optional prefix text shown in front of the actual input (e.g. for a currency like $ or £). Will be
   *         {@code null} if not set.
   */
  String getPrefix();

  /**
   * @param prefix the new {@link #getPrefix() prefix}.
   */
  void setPrefix(String prefix);

}
