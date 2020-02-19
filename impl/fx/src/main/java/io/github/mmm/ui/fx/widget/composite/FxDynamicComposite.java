/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiDynamicComposite} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxDynamicComposite<W extends Node, C extends UiWidget> extends FxComposite<W, C>
    implements UiDynamicComposite<C> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxDynamicComposite(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  public void addChild(C child, int index) {

    setParent(child, this);
    addChildWidget(child, index);
    if (index == -1) {
      this.children.add(child);
    } else {
      this.children.add(index, child);
    }
  }

  /**
   * @param child the child to add.
   * @param index the index where to insert the child.
   * @see #addChild(UiWidget, int)
   */
  protected abstract void addChildWidget(C child, int index);

  @Override
  public C removeChild(int index) {

    C child = this.children.remove(index);
    removeChildWidget(child, index);
    setParent(child, null);
    return child;
  }

  /**
   * @param child the child to remove.
   * @param index the index of the child to remove.
   * @see #removeChild(UiWidget)
   * @see #removeChild(int)
   */
  protected abstract void removeChildWidget(C child, int index);

}
