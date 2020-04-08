/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import io.github.mmm.ui.api.attribute.AttributeReadSize;
import io.github.mmm.ui.api.datatype.UiScreenType;

/**
 * This is the interface for the display where the UI objects are shown. <br>
 * <b>ATTENTION:</b><br>
 * Be aware of multi-monitor setups. This object will represent the main screen OR the current screen where the
 * {@link io.github.mmm.ui.api.widget.window.UiMainWindow} is located. This can depend on the underlying implementation or
 * in case of a web-application on the browser.
 *
 * @see UiContext#getScreen()
 *
 * @since 1.0.0
 */
public interface UiScreen extends AttributeReadSize {

  /**
   * @return the {@link UiScreenType} that categorizes the display size.
   */
  UiScreenType getType();

  /**
   * @return the <em>dots per inch</em> (DPI) rate of this display.
   */
  double getDpi();

  /**
   * @return screen size (diagonal) in inches.
   */
  double getSize();

  /**
   * Forces the display to update. Typically the screen-resolution does not change while your application is running.
   * Therefore values of {@link UiScreen} may be pre-calculated and cached. However, you can call this method before
   * reading resolution or screen type to force that you are getting most recent values.
   */
  void update();

}
