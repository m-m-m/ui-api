/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.chart;

import io.github.mmm.ui.datatype.UiPoint;

/**
 * {@link UiChart} showing data as a line chart. The data is given as {@link UiPoint}s that get connected to allow
 * interpolation and potentially extrapolation trends.
 *
 * @since 1.0.0
 */
public interface UiLineChart extends UiChart<UiPoint[]> {

}
