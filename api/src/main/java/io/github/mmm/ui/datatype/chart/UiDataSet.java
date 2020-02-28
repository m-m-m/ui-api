/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.chart;

import java.util.Objects;

import io.github.mmm.ui.datatype.color.Color;

/**
 * Datatype for a <em>dataset</em> of a {@link io.github.mmm.ui.widget.chart.UiChart chart}. Represents
 * {@link #getData()}.
 *
 * @param <V> type of {@link #getData() data}.
 * @since 1.0.0
 */
public class UiDataSet<V> {

  private final String title;

  private final Color color;

  private final V data;

  /**
   * The constructor.
   *
   * @param title the {@link #getTitle() title}.
   * @param color the #getColor() color}.
   * @param data the {@link #getData() data}.
   */
  public UiDataSet(String title, Color color, V data) {

    super();
    Objects.requireNonNull(title);
    this.title = title;
    this.color = color;
    this.data = data;
  }

  /**
   * @return the title of the data. Will e.g. be displayed in the legend and should therefore be a short label
   *         summarizing this dataset.
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @return color
   */
  public Color getColor() {

    return this.color;
  }

  /**
   * @return the actual data of this dataset.
   */
  public V getData() {

    return this.data;
  }

  @Override
  public String toString() {

    return this.title;
  }

  /**
   * @param <T> type of the {@link #getData() data}.
   * @param title the {@link #getTitle() title}.
   * @param data the {@link #getData() data}.
   * @return the new {@link UiDataSet}.
   */
  public static <T> UiDataSet<T> of(String title, T data) {

    return new UiDataSet<>(title, null, data);
  }
}
