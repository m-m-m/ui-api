/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.fx.widget.window.FxMainWindow;
import io.github.mmm.ui.spi.AbstractUiContext;
import io.github.mmm.ui.widget.window.UiMainWindow;
import javafx.stage.Stage;

/**
 * Implementation of {@link io.github.mmm.ui.UiContext} for JavaFx.
 */
public class FxContext extends AbstractUiContext {

  private final FxMainWindow mainWindow;

  /**
   * The constructor.
   *
   * @param primaryStage the primary {@link Stage}.
   */
  public FxContext(Stage primaryStage) {

    super();
    this.mainWindow = new FxMainWindow(this, primaryStage);
  }

  @Override
  public UiMainWindow getMainWindow() {

    return this.mainWindow;
  }

}
