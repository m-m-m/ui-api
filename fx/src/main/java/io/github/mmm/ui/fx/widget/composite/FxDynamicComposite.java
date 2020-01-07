/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiDynamicComposite} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxDynamicComposite<W extends Pane, C extends UiWidget> extends FxComposite<W, C>
    implements UiDynamicComposite<C> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxDynamicComposite(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  @Override
  public void addChild(C child, int index) {

    setParent(child, this);
    this.nativeWidget.getChildren().add(getNode(child));
    this.children.add(index, child);
  }

  @Override
  public boolean removeChild(C child) {

    boolean removed = this.children.remove(child);
    if (removed) {
      this.nativeWidget.getChildren().remove(getNode(child));
      setParent(child, null);
    }
    return removed;
  }

  @Override
  public C removeChild(int index) {

    this.nativeWidget.getChildren().remove(index);
    C child = this.children.remove(index);
    setParent(child, null);
    return child;
  }

}
