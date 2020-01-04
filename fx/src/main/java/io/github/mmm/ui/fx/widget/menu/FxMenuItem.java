/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiMenuItem;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiMenuItem} using JavaFx {@link MenuItem}.
 *
 * @since 1.0.0
 */
public class FxMenuItem extends FxAbstractMenuItem<MenuItem> implements UiMenuItem {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMenuItem(UiContext context) {

    super(context, new MenuItem());
  }

}
