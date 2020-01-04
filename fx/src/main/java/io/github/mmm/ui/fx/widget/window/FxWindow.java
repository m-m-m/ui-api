/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.window.UiWindow;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiWindow} using JavaFx {@link Stage}.
 *
 * @since 1.0.0
 */
public class FxWindow extends FxAbstractWindow<Stage> implements UiWindow {

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public FxWindow(UiContext context) {

    super(context, new Stage());
  }

}
