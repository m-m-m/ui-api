/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiEnabledFlags;
import io.github.mmm.ui.fx.widget.panel.FxButtonPanel;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.panel.UiButtonPanel;
import io.github.mmm.ui.widget.window.UiPopup;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiPopup} using JavaFx {@link Popup}.
 *
 * @since 1.0.0
 */
public class FxPopup extends FxAbstractWindow<Stage> implements UiPopup {

  private final FxButtonPanel buttonPanel;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public FxPopup(UiContext context) {

    super(context, new Stage());
    this.widget.initModality(Modality.APPLICATION_MODAL);
    this.buttonPanel = new FxButtonPanel(context);
    this.composite.getChildren().add(this.buttonPanel.getWidget());
  }

  @Override
  public UiButtonPanel getButtonPanel() {

    return this.buttonPanel;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.buttonPanel.setEnabled(enabled, UiEnabledFlags.PARENT);
  }

  @Override
  public UiButton createAndAddCloseButton() {

    // TODO i18n, etc.
    UiButton closeButton = this.context.createButton("close", (e) -> setVisible(false));
    this.buttonPanel.addChild(closeButton);
    return closeButton;
  }

}
