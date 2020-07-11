/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.data;

import io.github.mmm.base.sort.SortOrder;
import io.github.mmm.ui.api.attribute.AttributeWriteShowRowNumbers;
import io.github.mmm.value.PropertyPath;
import io.github.mmm.value.TypedPropertyPath;

/**
 * Abstract interface for widgets showing complex data in columns such as {@link UiDataTable}.
 *
 * @param <R> type of the data for the rows displayed by this widget. Typically a {@link io.github.mmm.bean.Bean}.
 * @since 1.0.0
 */
public abstract interface UiAbstractDataTable<R> extends UiAbstractDataWidget<R>, AttributeWriteShowRowNumbers {

  /**
   * @return the number of {@link #getColumn(int) columns} of this data widget.
   * @see java.util.List#size()
   */
  int getColumnCount();

  /**
   * @param <V> type of the cell values of the {@link UiColumn}.
   * @param property the {@link PropertyPath property} of the row data.
   * @return the new {@link UiColumn}.
   * @throws RuntimeException if the given {@code property} does not belong to the data model of this data widget.
   */
  <V> UiColumn<R, V> createColumn(TypedPropertyPath<V> property);

  /**
   * @param title the {@link UiColumn#getTitle() column header title}.
   * @param adapter the {@link UiAbstractDataWidget.ColumnAdapter} giving access to read (and write) the column cell
   *        values from the data model.
   * @param <V> type of the cell values of the {@link UiColumn}.
   * @return the new {@link UiColumn}.
   */
  <V> UiColumn<R, V> createColumn(String title, ColumnAdapter<R, V> adapter);

  /**
   * @param index is the index of the requested {@link UiColumn}. The index corresponds to the index when the
   *        {@link UiColumn} has been {@link #addColumn(UiColumn) added}. Reordering or hiding columns in the UI has no
   *        effect on the index. The value has to be in the range from {@code 0} to
   *        <code>{@link #getColumnCount()} - 1</code>.
   * @return the requested {@link UiColumn column}.
   * @see java.util.List#get(int)
   */
  UiColumn<R, ?> getColumn(int index);

  /**
   * @param column the {@link UiColumn} to add. Has to be {@link #createColumn(TypedPropertyPath) created} by this data
   *        widget.
   */
  default void addColumn(UiColumn<R, ?> column) {

    addColumn(column, -1);
  }

  /**
   * @param column the {@link UiColumn} to add. Has to be {@link #createColumn(TypedPropertyPath) created} by this data
   *        widget.
   * @param index the index where to add the new column.
   */
  void addColumn(UiColumn<R, ?> column, int index);

  /**
   * @param <V> type of the cell values of the {@link UiColumn}.
   * @param property the {@link PropertyPath property} of the row data.
   * @param index the index where to add the new column.
   * @return the new {@link UiColumn}.
   * @throws RuntimeException if the given {@code property} does not belong to the data model of this data widget.
   */
  default <V> UiColumn<R, V> addColumn(TypedPropertyPath<V> property) {

    return addColumn(property, -1);
  }

  /**
   * @param <V> type of the cell values of the {@link UiColumn}.
   * @param property the {@link PropertyPath property} of the row data.
   * @param index the index where to add the new column.
   * @return the new {@link UiColumn}.
   * @throws RuntimeException if the given {@code property} does not belong to the data model of this data widget.
   */
  default <V> UiColumn<R, V> addColumn(TypedPropertyPath<V> property, int index) {

    UiColumn<R, V> column = createColumn(property);
    addColumn(column, index);
    return column;
  }

  /**
   * @param columns the {@link UiColumn}s to add. Have to be {@link #createColumn(TypedPropertyPath) created} by this
   *        data widget.
   */
  @SuppressWarnings("unchecked")
  default void addColumns(UiColumn<R, ?>... columns) {

    for (UiColumn<R, ?> column : columns) {
      addColumn(column);
    }
  }

  /**
   * This method sorts the data with the given {@link SortOrder} according to the specified {@link UiColumn}s. The sort
   * priority is from the first {@link UiColumn} (primary sort) to the last (least significant sort). In case all values
   * of the first column are unique additional columns will have no effect on sorting.
   *
   * @param order is the {@link SortOrder}.
   * @param columns are the columns of this data-list to sort by.
   */
  @SuppressWarnings("unchecked")
  void sort(SortOrder order, UiColumn<R, ?>... columns);

  /**
   * @param filterHandler the {@link FilterHandler} to customize the {@link UiColumn#isFiltering() filtering}. Allows to
   *        override the filtering for individual columns or the entire table. Custom handling may trigger a server-side
   *        search and asynchronously update the data in the table.
   */
  void setFilterHandler(FilterHandler<R> filterHandler);

  /**
   * @param <R> type of the data model for the rows.
   */
  interface FilterHandler<R> {

    /**
     * @param column the {@link UiColumn} that has changed its filter.
     * @param complete - {@code true} if the user completed typing the {@link UiColumn#getFilterText() filter text},
     *        {@code false} if he may still be typing.
     * @return {@code true} if this handler could handle the filtering, {@code false} to fall back to the default
     *         behavior.
     * @see UiColumn#getFilterText()
     */
    boolean onFilter(UiColumn<R, ?> column, boolean complete);
  }

}
