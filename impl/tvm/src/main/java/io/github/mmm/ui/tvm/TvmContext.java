/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import io.github.mmm.ui.UiToggleGroup;
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

  /**
   * The constructor.
   */
  public TvmContext() {

    super(new TvmWidgetFactoryNative(), null, null);
    this.mainWindow = new TvmMainWindow(this);
  }

  @Override
  public UiMainWindow getMainWindow() {

    return this.mainWindow;
  }

  @Override
  public UiToggleGroup createToggleGroup() {

    return new TvmToggleGroup();
  }

}
