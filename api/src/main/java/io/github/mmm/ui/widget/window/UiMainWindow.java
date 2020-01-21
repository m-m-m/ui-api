/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.widget.menu.UiMenuBar;

/**
 * {@link UiAbstractWindow} that represents the <em>main window</em>. Each client application has an instance of this
 * main window. In case of a web-application this represents the browser window (or more precisely the tab running the
 * app).
 *
 * @see io.github.mmm.ui.UiContext#getMainWindow()
 *
 * @since 1.0.0
 */
public abstract interface UiMainWindow extends UiAbstractWindow {

  /**
   * @return the {@link UiMenuBar menu bar} of this window. Will be created and attached to the window on the first call
   *         of this method.
   */
  UiMenuBar getMenuBar();

  /**
   * @return {@code true} if the {@link #setPosition(double, double) position} of {@link UiAbstractWindow windows} is
   *         absolute (on {@link UiScreen.sf.mmm.client.ui.api.UiDisplay}), {@code false} if relative to this main window
   *         (MDI mode).
   */
  boolean isWindowPositionAbsolute();

}
