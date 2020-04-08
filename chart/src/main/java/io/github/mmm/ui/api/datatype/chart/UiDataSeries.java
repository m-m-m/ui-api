/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.chart;

/**
 * Interface for a series of values. Used as {@link UiDataSet#getData() data} of a {@link UiDataSet} for e.g. a
 * {@link io.github.mmm.ui.api.widget.chart.UiBarChart}.
 *
 * @since 1.0.0
 */
public interface UiDataSeries {

  /**
   * @return the number of {@link #getNumber(int) values} in this series.
   */
  int getCount();

  /**
   * @param i the index of the requested value in the range from {@code 0} to {@link #getCount()}-1.
   * @return the requested value as {@code float}.
   * @see #getNumber(int)
   */
  float get(int i);

  /**
   * @param i the index of the requested value in the range from {@code 0} to {@link #getCount()}-1.
   * @return the requested value as {@link Number} (e.g. java.math.BigDecimal}.
   */
  default Number getNumber(int i) {

    return Double.valueOf(get(i));
  }

  /**
   * @return {@code true} if this {@link UiDataSeries} natively contains primitive values and {@link #get(int)} should
   *         be preferred, {@code false} otherwise (e.g. if {@link java.math.BigDecimal} is used to represent values).
   */
  default boolean isPrimitive() {

    return true;
  }

}
