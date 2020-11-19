/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getSuffix() read} and {@link #setSuffix(String) write} the {@link #getSuffix() suffix}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteSuffix {

  /**
   * The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for the {@link #getSuffix() suffix} widget.
   */
  String STYLE_SUFFIX = "ui-suffix";

  /**
   * The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for the input widget if followed by a
   * {@link #getSuffix() suffix}.
   */
  String STYLE_WITH_SUFFIX = "with-suffix";

  /**
   * @return the optional suffix text shown after of the actual input (e.g. for a unit, currencies like €, etc.). Will
   *         be {@code null} if not set.
   */
  String getSuffix();

  /**
   * @param suffix the new {@link #getSuffix() suffix}.
   */
  void setSuffix(String suffix);

}
