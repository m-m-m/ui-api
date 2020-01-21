/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import org.teavm.jso.browser.Screen;
import org.teavm.jso.browser.Window;

import io.github.mmm.ui.spi.AbstractUiScreen;

/**
 * Implementation of {@link io.github.mmm.ui.UiScreen} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmScreen extends AbstractUiScreen {

  /**
   * The constructor.
   */
  public TvmScreen() {

    super();
    update();
  }

  @Override
  protected void doUpdate() {

    Window window = Window.current();
    this.dpi = window.getDevicePixelRatio();
    Screen screen = window.getScreen();
    this.width = screen.getAvailWidth();
    this.height = screen.getAvailHeight();
  }

}
