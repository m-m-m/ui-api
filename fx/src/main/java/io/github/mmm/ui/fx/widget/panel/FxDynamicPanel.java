/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxDynamicComposite;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import io.github.mmm.ui.widget.panel.UiDynamicPanel;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiDynamicComposite} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxDynamicPanel<W extends Pane> extends FxDynamicComposite<W, UiRegularWidget>
    implements UiDynamicPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxDynamicPanel(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

}
