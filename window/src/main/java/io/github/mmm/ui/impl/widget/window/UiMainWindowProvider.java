/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.widget.window;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.window.UiMainWindow;

/**
 * Provider of {@link UiMainWindow}.
 *
 * @since 1.0.0
 */
public final class UiMainWindowProvider {

  /** The {@link UiMainWindow#get() singleton instance} of {@link UiMainWindow}. */
  public static final UiMainWindow MAIN_WINDOW = UiWidgetFactoryNative.get().create(UiMainWindow.class, true);

  private UiMainWindowProvider() {

  }

}
