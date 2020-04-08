/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.chart;

import java.util.Objects;

import io.github.mmm.ui.api.datatype.color.Color;

/**
 * Datatype for a <em>dataset</em> of a {@link io.github.mmm.ui.api.widget.chart.UiChart chart}. Represents
 * {@link #getData()}.
 *
 * @param <V> type of {@link #getData() data}.
 * @since 1.0.0
 */
public class UiDataSet<V> {

  private static final int ALPHA = 0xE0000000;

  private static final int[] COLS = { 0xE06030, 0xF0A030, 0x50B050, 0x40A0B0, 0x4050B0, 0x9040C0, 0xF00070, 0x4040E0,
  0xA08080, 0xC04070, 0xF030A0, 0x5020A0, 0x20A0F0, 0x208020, 0xFF2020, 0xFFFF40 };

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
   * @return the {@link Color} used to visualize the data of this dataset (its bars in bar-chart, slices in pie-chart,
   *         etc.).
   */
  public Color getColor() {

    return this.color;
  }

  /**
   * @param i the index of this dataset in the chart.
   * @return the {@link #getColor() color} or the default color for the given index if {@link #getColor()} is
   *         {@code null}.
   */
  public Color getColor(int i) {

    if (this.color != null) {
      return this.color;
    }
    int c = COLS[i % COLS.length];
    int segment = ((i / COLS.length) % 3);
    if (segment == 1) {
      int rot = (c & 0xFF) << 16;
      c = (c >> 8) + rot;
    } else if (segment == 2) {
      int rot = (c & 0xFFFF) << 8;
      c = (c >> 16) + rot;
    }
    return new Color(c + ALPHA);
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
