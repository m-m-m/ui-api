/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxDynamicCompositePane;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiFailureComposite;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiFailureComposite} using JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxFailureComposite<W extends Pane, C extends UiWidget> extends FxDynamicCompositePane<W, C>
    implements UiFailureComposite<C> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxFailureComposite(UiContext context, W widget) {

    super(context, widget);
  }

  @Override
  protected void doSetValidationFailure(String error) {

    super.doSetValidationFailure(error);
    // TODO: apply to view
  }
}
