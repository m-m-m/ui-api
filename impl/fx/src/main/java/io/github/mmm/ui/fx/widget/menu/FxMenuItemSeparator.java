/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiMenuItem;
import io.github.mmm.ui.widget.menu.UiMenuItemSeparator;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Implementation of {@link UiMenuItem} using JavaFx {@link MenuItem}.
 *
 * @since 1.0.0
 */
public class FxMenuItemSeparator extends FxAbstractMenuItem<SeparatorMenuItem> implements UiMenuItemSeparator {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMenuItemSeparator(UiContext context) {

    super(context, new SeparatorMenuItem());
  }

}
