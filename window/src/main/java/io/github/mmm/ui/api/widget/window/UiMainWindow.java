/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.window;

import io.github.mmm.ui.api.attribute.AttributeReadPosition;
import io.github.mmm.ui.api.attribute.AttributeReadSize;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.impl.widget.window.UiMainWindowProvider;

/**
 * {@link UiAbstractWindow} that represents the <em>main window</em>. Each client application {@link #get() has a single
 * instance} of this main window. In case of a web-application this represents the browser window (or more precisely the
 * tab running the app).<br>
 * <b>ATTENTION:</b><br>
 * There must be only a single instance of {@link UiMainWindow} that shall be accessed via {@link #get()}. Never
 * manually create {@link UiMainWindow} via {@link io.github.mmm.ui.api.factory.UiWidgetFactoryNative#create(Class)}.
 * This is only possible for modularity of the UI implementations and direct creation is unspecified and behavior can
 * change in future versions.
 *
 * @since 1.0.0
 */
public abstract interface UiMainWindow extends UiAbstractWindow, UiNativeWidget {

  /**
   * <b>ATTENTION:</b> It is strictly discouraged to modify the position of the main window by the application. In case
   * of a web-application this will move the browser window what will cause unacceptable impact on usability. However,
   * if you are fully aware of what you are doing, it is technically possible to cast the result of this method to
   * {@link io.github.mmm.ui.api.attribute.AttributeWritePosition} to do so.
   */
  @Override
  AttributeReadPosition getPosition();

  /**
   * <b>ATTENTION:</b> It is strictly discouraged to modify the size of the main window by the application. In case of a
   * web-application this will resize the browser window what will cause unacceptable impact on usability. However, if
   * you are fully aware of what you are doing, it is technically possible to cast the result of this method to
   * {@link io.github.mmm.ui.api.attribute.AttributeWriteSizeInPixel} to do so.
   */
  @Override
  AttributeReadSize getSize();

  /**
   * @return {@code true} if the {@link #getPosition() position} of {@link UiAbstractWindow windows} is absolute (on
   *         {@link io.github.mmm.ui.api.UiScreen}), {@code false} if relative to this main window (MDI mode).
   */
  boolean isWindowPositionAbsolute();

  /**
   * @return the {@link UiMainWindow} instance.
   */
  static UiMainWindow get() {

    return UiMainWindowProvider.MAIN_WINDOW;
  }

}
