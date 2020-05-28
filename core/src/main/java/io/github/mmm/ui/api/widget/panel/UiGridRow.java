/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiMutablePanel} that represents a row in a {@link UiGridPanel}.
 *
 * @since 1.0.0
 */
public interface UiGridRow extends UiMutablePanel {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name this widget. */
  String STYLE = "ui-gridrow";

  @Override
  default void addChild(UiRegularWidget child, int index) {

    addChild(child, index, 1, 1);
  }

  /**
   * Inserts the given {@code child} at the given {@code index} with the given {@code colspan}.
   *
   * @see #addChild(UiRegularWidget, int)
   *
   * @param child is the {@link UiWidget} to add as child of this composite.
   * @param index is the {@link #getChild(int) index} of the new child. It has to be in the range from {@code 0} to
   *        {@link #getChildCount()}.
   * @param colspan the number of columns the given {@code child} widget should span. The default is {@code 1} for a
   *        single column/cell. Use a higher number to join multiple cells to the right.
   */
  default void addChild(UiRegularWidget child, int index, int colspan) {

    addChild(child, index, colspan, 1);
  }

  /**
   * Inserts the given {@code child} at the given {@code index} with the given {@code colspan} and {@code rowspan}.
   *
   * @see #addChild(UiRegularWidget, int)
   *
   * @param child is the {@link UiWidget} to add as child of this composite.
   * @param index is the {@link #getChild(int) index} of the new child. It has to be in the range from {@code 0} to
   *        {@link #getChildCount()}.
   * @param colspan the number of columns the given {@code child} widget should span. The default is {@code 1} for a
   *        single column/cell. Use a higher number to join multiple cells.
   * @param rowspan the number of rows the given {@code child} widget should span. The default is {@code 1} for a single
   *        row/cell. Use a higher number to join multiple cells downwards.
   */
  void addChild(UiRegularWidget child, int index, int colspan, int rowspan);

  /**
   * Sets the given {@code child} at the given {@code index} with the given {@code colspan} and {@code rowspan}. Any
   * potential child in the specified cell will be replaced.
   *
   * @see #addChild(UiRegularWidget, int, int, int)
   *
   * @param child is the {@link UiWidget} to add as child of this composite.
   * @param index is the {@link #getChild(int) index} of the new child. It has to be in the range from {@code 0} to
   *        {@link #getChildCount()}.
   * @param colspan the number of columns the given {@code child} widget should span. The default is {@code 1} for a
   *        single column/cell. Use a higher number to join multiple cells.
   * @param rowspan the number of rows the given {@code child} widget should span. The default is {@code 1} for a single
   *        row/cell. Use a higher number to join multiple cells downwards.
   */
  void setChild(UiRegularWidget child, int index, int colspan, int rowspan);

}
