/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #isShowRowNumbers() read} and {@link #setShowRowNumbers(boolean) write} the
 * {@link #isShowRowNumbers() show row numbers flag}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteShowRowNumbers {

  /** The title of the row-number column. */
  String ROW_NUMBER_HEADER_TITLE = "#";

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} for the row number. */
  String STYLE_ROW_NUMBER = "rownum";

  /**
   * @return {@code true} if line numbers should be shown (a first column is displayed showing a running number starting
   *         with {@code 1} for each line/row like in Execl), {@code false} otherwise.
   */
  boolean isShowRowNumbers();

  /**
   * @param showLineNumbers is the new value of {@link #isShowRowNumbers()}.
   */
  void setShowRowNumbers(boolean showLineNumbers);

}
