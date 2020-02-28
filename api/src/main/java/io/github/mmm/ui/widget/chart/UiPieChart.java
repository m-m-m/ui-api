/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.chart;

import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiChart} for pie-charts that display the data in a circle sliced into segments according to their
 * {@link UiDataSet#getData() data}. The total circle (360 degrees) correlates to the sum of
 * {@link #setData(java.util.Collection) all datasets}. Therefore it is not required to provide the data as percentage
 * and you may provide the original values in the according unit.
 *
 * @since 1.0.0
 */
public interface UiPieChart extends UiChart<Number>, UiNativeWidget {

}
