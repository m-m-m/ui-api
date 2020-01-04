/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.widget.UiAtomicWidget;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;

/**
 * {@link UiAtomicWidget} based on JavaFx {@link Control} and {@link FxStyleableWidget}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public interface FxAtomicWidget<W extends Control> extends FxStyleableWidget<W>, UiAtomicWidget {

  @Override
  default String getTooltip() {

    Tooltip tooltip = getNativeWidget().getTooltip();
    if (tooltip != null) {
      String text = tooltip.getText();
      if (text != null) {
        return text;
      }
    }
    return "";
  }

  @Override
  default void setTooltip(String tooltip) {

    Tooltip fxTooltip = getNativeWidget().getTooltip();
    if (fxTooltip == null) {
      fxTooltip = new Tooltip(tooltip);
      getNativeWidget().setTooltip(fxTooltip);
    } else {
      fxTooltip.setText(tooltip);
    }
  }

}
