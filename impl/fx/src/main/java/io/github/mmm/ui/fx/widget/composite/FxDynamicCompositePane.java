/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiDynamicComposite} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxDynamicCompositePane<W extends Pane, C extends UiWidget> extends FxDynamicComposite<W, C> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxDynamicCompositePane(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  protected void addChildWidget(C child, int index) {

    ObservableList<Node> childList = this.widget.getChildren();
    if (index == -1) {
      childList.add(getTopNode(child));
    } else {
      childList.add(index, getTopNode(child));
    }
  }

  @Override
  protected void removeChildWidget(C child, int index) {

    this.widget.getChildren().remove(getTopNode(child));
  }

}
