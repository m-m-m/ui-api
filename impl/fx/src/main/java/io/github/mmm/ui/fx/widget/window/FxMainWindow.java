/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.menu.FxMenuBar;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import io.github.mmm.ui.widget.window.UiMainWindow;
import io.github.mmm.ui.widget.window.UiWindow;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiWindow} using JavaFx {@link Stage}.
 *
 * @since 1.0.0
 */
public class FxMainWindow extends FxAbstractWindow<Stage> implements UiMainWindow {

  private FxMenuBar menuBar;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   * @param widget the {@link #getWidget() JavaFx widget} (primary stage).
   */
  public FxMainWindow(UiContext context, Stage widget) {

    super(context, widget);
  }

  @Override
  public UiMenuBar getMenuBar() {

    if (this.menuBar == null) {
      this.menuBar = new FxMenuBar(this.context);
      this.composite.getChildren().add(0, this.menuBar.getWidget());
    }
    return this.menuBar;
  }

  @Override
  protected int getChildOffset() {

    int offset = super.getChildOffset();
    if (this.menuBar != null) {
      offset++;
    }
    return offset;
  }

  @Override
  public boolean isWindowPositionAbsolute() {

    // TODO Auto-generated method stub
    return false;
  }

}
