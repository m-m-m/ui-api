/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.chart;

import java.util.Arrays;
import java.util.Objects;

/**
 * Implementation of {@link UiDataSeries} based on {@code Number[]}.
 */
public class UiDataSeriesNumber implements UiDataSeries {

  private final Number[] values;

  /**
   * The constructor.
   *
   * @param values the underlying values.
   */
  public UiDataSeriesNumber(Number[] values) {

    super();
    Objects.requireNonNull(values);
    this.values = values;
  }

  @Override
  public int getCount() {

    return this.values.length;
  }

  @Override
  public Number getNumber(int i) {

    return this.values[i];
  }

  @Override
  public double get(int i) {

    if (this.values[i] == null) {
      return 0;
    }
    return this.values[i].doubleValue();
  }

  @Override
  public boolean isPrimitive() {

    return false;
  }

  @Override
  public String toString() {

    return Arrays.toString(this.values);
  }

}
