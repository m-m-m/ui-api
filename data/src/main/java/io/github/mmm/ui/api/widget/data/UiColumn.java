/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.data;

import java.util.Comparator;

import io.github.mmm.base.sort.SortOrder;
import io.github.mmm.ui.api.attribute.AttributeWriteResizable;
import io.github.mmm.ui.api.attribute.AttributeWriteTitle;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * {@link UiWidget} for a column of a {@link UiAbstractDataWidget}.<br>
 * By default a column is {@link #isReadOnly() read-only}. If you {@link #setReadOnly(boolean) set read-only} to
 * {@code false}, the cells in this column will be editable. In case you {@link #setReadOnlyFixed(Boolean) set read-only
 * fixed} to {@link Boolean#TRUE}, you can force the cells of this row to be immutable even for inline editing.
 *
 * @param <R> type of the row data. Typically a {@link io.github.mmm.bean.Bean}.
 * @param <V> type of the value for the cells in this column.
 * @since 1.0.0
 */
public interface UiColumn<R, V> extends UiWidget, AttributeWriteTitle, AttributeWriteResizable {

  /**
   * @return {@code true} if this column allows filtering, {@code false} otherwise. Typically filtering renders a text
   *         input at the bottom of the column header that allows to search for data in the cells. All rows that have
   *         values in this column which do not contain the filter text will be hidden from the data widget.
   */
  boolean isFiltering();

  /**
   * @param filtering
   */
  void setFiltering(boolean filtering);

  /**
   * @return the current filter text for {@link #isFiltering() filtering}.
   */
  String getFilterText();

  /**
   * @return the current {@link SortOrder} of this column or {@code null} if unsorted.
   */
  SortOrder getSortOrder();

  /**
   * @return {@code true} if a {@link #getSortComparator() sort comparator} is not {@code null} and the data can be
   *         sorted according to this column, {@code false} otherwise.
   */
  default boolean isSortable() {

    return (getSortComparator() != null);
  }

  /**
   * @return the {@link Comparator} used to sort the values. May be {@code null} to disable sorting.
   */
  Comparator<V> getSortComparator();

  /**
   * @param sortComparator the new value of {@link #getSortComparator()}. May be {@code null} to disable sorting.
   * @see Comparator#naturalOrder()
   */
  void setSortComparator(Comparator<V> sortComparator);

  /**
   * @return {@code true} if this column is editable so the end-user can potentially edit the cell values of this column
   *         with inline editing.
   * @see #isReadOnly()
   */
  default boolean isEditable() {

    return !isReadOnly();
  }

  /**
   * @param editable the new value of {@link #isEditable()}.
   * @see #setReadOnly(boolean)
   */
  default void setEditable(boolean editable) {

    setReadOnly(!editable);
  }

}
