/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.chart;

import java.util.Collection;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.api.attribute.AttributeWriteTitle;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiRegularWidget} that displays a <em>chart</em>. A chart visualizes data in a graphical diagram.
 *
 * @param <D> type of the chart {@link UiDataSet#getData() data}.
 * @since 1.0.0
 */
public interface UiChart<D> extends AttributeWriteTitle, UiRegularWidget {

  /**
   * @return the {@link Direction} where the legend should be placed. Will be {@code null} if legend is disabled.
   */
  Direction getLegnedPlacement();

  /**
   * @param placement the new value of {@link #getLegnedPlacement()}.
   */
  void setLegendPlacement(Direction placement);

  /**
   * @param dataSets the {@link UiDataSet}s to set and display by this chart.
   */
  @SuppressWarnings("unchecked")
  void setData(UiDataSet<D>... dataSets);

  /**
   * @param dataSets the {@link Collection} of {@link UiDataSet}s.
   */
  default void setData(Collection<UiDataSet<D>> dataSets) {

    setData(dataSets.toArray(UiDataSet[]::new));
  }

}
