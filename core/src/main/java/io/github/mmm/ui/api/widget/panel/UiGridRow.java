/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiRemovableComposite;

/**
 * {@link UiMutablePanel} that represents a row in a {@link UiGridPanel}.<br>
 * <b>ATTENTION:</b> Unlike other {@link io.github.mmm.ui.api.widget.composite.UiMutableComposite}s where the
 * {@link #getChildIndex(UiRegularWidget) index} is the position of a linear list of children, here the {@code index} is
 * the column in this grid row. This allows a more intuitive API usage when features like {@code colspan} are used. As a
 * result {@link #getChildCount()} will return the number of columns in this row or in other words the maximum column
 * number where a child has been set.
 *
 * @since 1.0.0
 */
public interface UiGridRow extends UiRemovableComposite<UiRegularWidget> {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name this widget. */
  String STYLE = "ui-gridrow";

  /**
   * Sets the given {@code child} in the call at the given {@code column}. A potentially existing child in the specified
   * cell will be replaced.
   *
   * @param child is the {@link UiWidget} to set as child in the given {@code column}. May be {@code null} to clear the
   *        specified {@code column}.
   * @param column is the column where to place the given {@code child}. May internally create empty cells to the left
   *        as needed.
   */
  default void setChild(UiRegularWidget child, int column) {

    setChild(child, column, 1, 1);
  }

  /**
   * Sets the given {@code child} in the call at the given {@code column} with the given {@code colspan}. A potentially
   * existing child in the specified cell will be replaced.
   *
   * @param child is the {@link UiWidget} to set as child in the given {@code column}. May be {@code null} to clear the
   *        specified {@code column}.
   * @param column is the column where to place the given {@code child}. May internally create empty cells to the left
   *        as needed.
   * @param colspan the number of columns the given {@code child} widget should span. The default is {@code 1} for a
   *        single column/cell. Use a higher number to join multiple cells.
   */
  default void setChild(UiRegularWidget child, int column, int colspan) {

    setChild(child, column, colspan, 1);
  }

  /**
   * Sets the given {@code child} in the call at the given {@code column} with the given {@code colspan} and
   * {@code rowspan}. A potentially existing child in the specified cell will be replaced.<br>
   * <b>ATTENTION:</b> When using {@code colspan} you have to manually ensure consistency or results and behaviour is
   * unspecified. See e.g. when setting a child into cell at {@code column} with index {@code 0} and with a
   * {@code colspan} of e.g. {@code 2} you shall not set another child into cell at {@code column} with index {@code 1}
   * as this is already occupied by the previous child.
   *
   * @param child is the {@link UiWidget} to set as child in the given {@code column}. May be {@code null} to clear the
   *        specified {@code column}.
   * @param column is the column where to place the given {@code child}. May internally create empty cells to the left
   *        as needed.
   * @param colspan the number of columns the given {@code child} widget should span. The default is {@code 1} for a
   *        single column/cell. Use a higher number to join multiple cells.
   * @param rowspan the number of rows the given {@code child} widget should span. The default is {@code 1} for a single
   *        row/cell. Use a higher number to join multiple cells downwards.
   */
  void setChild(UiRegularWidget child, int column, int colspan, int rowspan);

}
