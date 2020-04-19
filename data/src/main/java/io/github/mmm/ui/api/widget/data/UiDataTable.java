/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.data;

import java.util.List;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;

/**
 * {@link UiAbstractDataWidget} that shows the data as a table (data grid) with the {@link #getColumn(int) columns} as
 * header. Its {@link #getValue() value} is a {@link List} of data values that are displayed as rows of this data table.
 *
 * @param <R> type of the data for the rows displayed by this widget. Typically a {@link io.github.mmm.bean.Bean}.
 * @since 1.0.0
 */
public interface UiDataTable<R> extends UiAbstractDataTable<R>, UiValidatableWidget<List<R>>, UiNativeWidget {

  /**
   * @param <R> type of the data for the rows displayed by this widget.
   * @param template an instance of the row data as template.
   * @return the new {@link UiDataTable}.
   */
  static <R> UiDataTable<R> of(R template) {

    UiDataTable<R> widget = UiWidgetFactoryNative.get().create(UiDataTable.class);
    return widget;
  }

}
