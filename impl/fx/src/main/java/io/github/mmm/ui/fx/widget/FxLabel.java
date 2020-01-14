/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiLabel;
import javafx.scene.control.Label;

/**
 * Implementation of {@link UiLabel} using JavaFx {@link Label}.
 *
 * @since 1.0.0
 */
public class FxLabel extends FxWidgetControl<Label> implements UiLabel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxLabel(UiContext context) {

    super(context, new Label());
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
