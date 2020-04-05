/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiPoint;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiChart} showing data as a line chart. The data is given as {@link UiPoint}s that get connected to allow
 * interpolation and potentially extrapolation trends.
 *
 * @since 1.0.0
 */
public interface UiLineChart extends UiChart<UiPoint[]>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param title the {@link #getTitle() title}.
   * @param legendPlacement the {@link #getLegnedPlacement() legend placement}.
   * @param dataSets the {@link #setData(UiDataSet...) data sets}.
   * @return the new {@link UiLineChart}.
   */
  @SuppressWarnings("unchecked")
  static UiLineChart of(UiContext context, String title, Direction legendPlacement, UiDataSet<UiPoint[]>... dataSets) {

    UiLineChart chart = context.create(UiLineChart.class);
    chart.setTitle(title);
    chart.setLegendPlacement(legendPlacement);
    if ((dataSets != null) && (dataSets.length > 0)) {
      chart.setData(dataSets);
    }
    return chart;
  }

}
