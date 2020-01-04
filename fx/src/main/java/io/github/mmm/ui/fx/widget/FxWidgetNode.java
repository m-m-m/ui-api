/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;
import javafx.scene.Node;

/**
 * Implementation of {@link UiWidget} for JavaFx {@link Node}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetNode<W extends Node> extends FxWidgetStyleable<W> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxWidgetNode(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  public void setId(String id) {

    this.nativeWidget.setId(id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    this.nativeWidget.setVisible(visible);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.nativeWidget.setDisable(!enabled);
  }

}
