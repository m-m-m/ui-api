/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.chart;

import io.github.mmm.ui.api.datatype.chart.UiDataSeries;

/**
 * {@link UiChart} showing a bar char with {@link UiDataSeries series of data}.
 *
 * @since 1.0.0
 */
public interface UiBarChart extends UiChart<UiDataSeries> {

  /**
   * @param labels the labels of the series.
   */
  void setSeriesLabels(String... labels);

}
