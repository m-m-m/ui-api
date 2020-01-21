/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.UiDispatcher;
import io.github.mmm.ui.UiScreen;
import io.github.mmm.ui.UiToggleGroup;
import io.github.mmm.ui.datatype.UiSeverity;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.fx.widget.window.FxMainWindow;
import io.github.mmm.ui.spi.AbstractUiContext;
import io.github.mmm.ui.widget.window.UiMainWindow;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Implementation of {@link io.github.mmm.ui.UiContext} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxContext extends AbstractUiContext {

  private final FxMainWindow mainWindow;

  private final FxScreen screen;

  private final FxDispatcher dispatcher;

  /**
   * The constructor.
   *
   * @param primaryStage the primary {@link Stage}.
   */
  public FxContext(Stage primaryStage) {

    super();
    this.mainWindow = new FxMainWindow(this, primaryStage);
    this.screen = new FxScreen(Screen.getPrimary());
    this.dispatcher = new FxDispatcher();
  }

  @Override
  public UiMainWindow getMainWindow() {

    return this.mainWindow;
  }

  @Override
  public UiScreen getScreen() {

    return this.screen;
  }

  @Override
  public UiDispatcher getDispatcher() {

    return this.dispatcher;
  }

  @Override
  public UiToggleGroup createToggleGroup() {

    return new FxToggleGroup();
  }

  @Override
  public void showPopup(String message, UiSeverity severity, String title, String details, UiAction... actions) {

    // TODO Auto-generated method stub

  }

}
