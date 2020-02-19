/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxDynamicCompositePane;
import io.github.mmm.ui.widget.button.UiAbstractButton;
import io.github.mmm.ui.widget.panel.UiButtonPanel;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiButtonPanel} using JavaFx {@link HBox}.
 *
 * @since 1.0.0
 */
public class FxButtonPanel extends FxDynamicCompositePane<HBox, UiAbstractButton> implements UiButtonPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxButtonPanel(UiContext context) {

    super(context, new HBox());
  }

}
