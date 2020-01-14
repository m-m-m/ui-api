/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.menu.UiMenuItemRadioButton;
import javafx.scene.control.RadioMenuItem;

/**
 * Implementation of {@link UiMenuItemRadioButton} using JavaFx {@link RadioMenuItem}.
 *
 * @since 1.0.0
 */
public class FxMenuItemRadioButton extends FxAbstractMenuItem<RadioMenuItem> implements UiMenuItemRadioButton {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMenuItemRadioButton(UiContext context) {

    super(context, new RadioMenuItem());
  }

  @Override
  public Boolean getValue() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValue(Boolean checked) {

    this.widget.setSelected(Boolean.TRUE.equals(checked));
  }

}
