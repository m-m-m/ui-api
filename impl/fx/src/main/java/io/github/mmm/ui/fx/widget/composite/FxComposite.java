/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiComposite;
import javafx.scene.Node;

/**
 * Implementation of {@link UiComposite} using JavaFx {@link Node}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxComposite<W extends Node, C extends UiWidget> extends FxWidgetNode<W>
    implements UiComposite<C> {

  /** @see #getChild(int) */
  protected final List<C> children;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxComposite(UiContext context, W widget) {

    super(context, widget);
    this.children = new ArrayList<>();
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public C getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public int getChildIndex(C child) {

    if (child == null) {
      return -1;
    }
    return this.children.indexOf(child);
  }

}
