/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.chart;

import java.util.Arrays;
import java.util.Objects;

/**
 * Implementation of {@link UiDataSeries} based on {@code double[]}.
 */
public class UiDataSeriesDouble implements UiDataSeries {

  private final float[] values;

  /**
   * The constructor.
   *
   * @param values the underlying values.
   */
  public UiDataSeriesDouble(float... values) {

    super();
    Objects.requireNonNull(values);
    this.values = values;
  }

  @Override
  public int getCount() {

    return this.values.length;
  }

  @Override
  public float get(int i) {

    return this.values[i];
  }

  @Override
  public String toString() {

    return Arrays.toString(this.values);
  }

}
