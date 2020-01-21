/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.spi.AbstractUiScreen;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Implementation of {@link io.github.mmm.ui.UiScreen} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxScreen extends AbstractUiScreen {

  private final Screen screen;

  /**
   * The constructor.
   *
   * @param screen the ({@link Screen#getPrimary() primary}) {@link Screen}.
   */
  public FxScreen(Screen screen) {

    super();
    this.screen = screen;
    update();
  }

  @Override
  protected void doUpdate() {

    Rectangle2D bounds = this.screen.getVisualBounds();
    this.dpi = this.screen.getDpi();
    this.width = bounds.getWidth();
    this.height = bounds.getHeight();
  }

}
