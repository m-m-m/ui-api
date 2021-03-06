/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.datatype.chart.UiDataSeries;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiBarChart} showing a bar char with vertical bars leading to the top.
 *
 * @since 1.0.0
 */
public interface UiBarChartVertical extends UiBarChart, UiNativeWidget {

  /**
   * @param title the {@link #getTitle() title}.
   * @param legendPlacement the {@link #getLegnedPlacement() legend placement}.
   * @param dataSets the {@link #setData(UiDataSet...) data sets}.
   * @return the new {@link UiBarChartVertical}.
   */
  @SuppressWarnings("unchecked")
  static UiBarChartVertical of(String title, Direction legendPlacement, UiDataSet<UiDataSeries>... dataSets) {

    UiBarChartVertical chart = UiWidgetFactoryNative.get().create(UiBarChartVertical.class);
    chart.setTitle(title);
    chart.setLegendPlacement(legendPlacement);
    if ((dataSets != null) && (dataSets.length > 0)) {
      chart.setData(dataSets);
    }
    return chart;
  }

}
