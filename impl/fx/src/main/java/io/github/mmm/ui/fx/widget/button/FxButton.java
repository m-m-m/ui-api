/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.button;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.FxClickableWidget;
import io.github.mmm.ui.widget.button.UiButton;
import javafx.scene.control.Button;

/**
 * Implementation of {@link UiButton} using JavaFx {@link Button}.
 *
 * @since 1.0.0
 */
public class FxButton extends FxClickableWidget<Button> implements UiButton {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxButton(UiContext context) {

    super(context, new Button());
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnAction(this::onAction);
  }

  @Override
  public String getLabel() {

    return this.widget.getText();
  }

  @Override
  public void setLabel(String label) {

    this.widget.setText(label);
  }

}
