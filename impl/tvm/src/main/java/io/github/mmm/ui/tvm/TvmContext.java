/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import org.teavm.jso.browser.Window;

import io.github.mmm.ui.UiDispatcher;
import io.github.mmm.ui.UiScreen;
import io.github.mmm.ui.UiToggleGroup;
import io.github.mmm.ui.datatype.UiSeverity;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.spi.AbstractUiContext;
import io.github.mmm.ui.tvm.widget.window.TvmMainWindow;
import io.github.mmm.ui.widget.window.UiMainWindow;

/**
 * Implementation of {@link io.github.mmm.ui.UiContext} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmContext extends AbstractUiContext {

  private final TvmMainWindow mainWindow;

  private final TvmScreen screen;

  private final TvmDispatcher dispatcher;

  /**
   * The constructor.
   */
  public TvmContext() {

    super(new TvmWidgetFactoryNative(), null, null);
    this.mainWindow = new TvmMainWindow(this);
    this.screen = new TvmScreen();
    this.dispatcher = new TvmDispatcher();
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

    return new TvmToggleGroup();
  }

  @Override
  public void showPopup(String message, UiSeverity severity, String title, String details, UiAction... actions) {

    // TODO: just a temporary hack, we will build real windows (modal popup and regular window) as web-components with
    // glass-pane, etc.
    Window.alert(message);
  }

}
