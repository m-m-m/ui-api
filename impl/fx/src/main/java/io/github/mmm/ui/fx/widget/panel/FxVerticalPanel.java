/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiVerticalPanel} using JavaFx {@link VBox}.
 *
 * @since 1.0.0
 */
public class FxVerticalPanel extends FxDynamicPanel<VBox> implements UiVerticalPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxVerticalPanel(UiContext context) {

    super(context, new VBox());
  }

}
