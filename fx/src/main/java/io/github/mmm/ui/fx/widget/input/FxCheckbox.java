/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiTextInput;
import javafx.scene.control.CheckBox;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link CheckBox}.
 *
 * @since 1.0.0
 */
public class FxCheckbox extends FxInput<CheckBox, Boolean> implements UiCheckbox {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxCheckbox(UiContext context) {

    super(context, new CheckBox());
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.nativeWidget.setOnAction(this::onAction);
  }

  @Override
  public String getLabel() {

    return this.nativeWidget.getText();
  }

  @Override
  public void setLabel(String label) {

    this.nativeWidget.setText(label);
  }

  @Override
  public boolean isSelected() {

    return this.nativeWidget.isSelected();
  }

  @Override
  public void setSelected(boolean selected) {

    this.nativeWidget.setSelected(selected);
  }

}
