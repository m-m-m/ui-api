/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.widget.menu;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;

/**
 * Provides the {@link UiMenuBar}.
 *
 * @since 1.0.0
 */
public final class UiMenuBarProvider {

  /** The {@link UiMenuBar#get() singleton instance} of {@link UiMenuBar}. */
  public static final UiMenuBar MENU_BAR = UiWidgetFactoryNative.get().create(UiMenuBar.class, true);

  private UiMenuBarProvider() {

  }

}
