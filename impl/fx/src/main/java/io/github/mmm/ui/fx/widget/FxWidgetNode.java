/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;
import javafx.scene.Node;

/**
 * Implementation of {@link UiWidget} for JavaFx {@link Node}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetNode<W extends Node> extends FxWidgetStyleable<W> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetNode(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  public Node getTopWidget() {

    return this.widget;
  }

  @Override
  public void setId(String id) {

    getTopWidget().setId(id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    getTopWidget().setVisible(visible);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    this.widget.pseudoClassStateChanged(CLASS_READ_ONLY, readOnly);
  }

}
