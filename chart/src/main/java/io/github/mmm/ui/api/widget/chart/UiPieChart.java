/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiChart} for pie-charts that display the data in a circle sliced into segments according to their
 * {@link UiDataSet#getData() data}. The total circle (360 degrees) correlates to the sum of
 * {@link #setData(java.util.Collection) all datasets}. Therefore it is not required to provide the data as percentage
 * and you may provide the original values in the according unit.
 *
 * @since 1.0.0
 */
public interface UiPieChart extends UiChart<Number>, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param title the {@link #getTitle() title}.
   * @param legendPlacement the {@link #getLegnedPlacement() legend placement}.
   * @param dataSets the {@link #setData(UiDataSet...) data sets}.
   * @return the new {@link UiPieChart}.
   */
  @SuppressWarnings("unchecked")
  static UiPieChart of(UiContext context, String title, Direction legendPlacement, UiDataSet<Number>... dataSets) {

    UiPieChart chart = context.create(UiPieChart.class);
    chart.setTitle(title);
    chart.setLegendPlacement(legendPlacement);
    if ((dataSets != null) && (dataSets.length > 0)) {
      chart.setData(dataSets);
    }
    return chart;
  }

}
