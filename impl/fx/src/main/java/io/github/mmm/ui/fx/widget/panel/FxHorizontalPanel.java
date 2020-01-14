/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.panel.UiHorizontalPanel;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiHorizontalPanel} using JavaFx {@link HBox}.
 *
 * @since 1.0.0
 */
public class FxHorizontalPanel extends FxDynamicPanel<HBox> implements UiHorizontalPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxHorizontalPanel(UiContext context) {

    super(context, new HBox());
  }

}
