/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.UiToggleGroup;
import io.github.mmm.ui.fx.FxToggleGroup;
import io.github.mmm.ui.widget.input.UiRadioButton;
import io.github.mmm.ui.widget.input.UiTextInput;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link CheckBox}.
 *
 * @since 1.0.0
 */
public class FxRadioButton extends FxInput<RadioButton, Boolean> implements UiRadioButton {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxRadioButton(UiContext context) {

    super(context, new RadioButton());
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.selectedProperty().addListener(this::onValueChange);
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

  @Override
  public Boolean getValue() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValueNative(Boolean selected) {

    this.widget.setSelected(Boolean.TRUE.equals(selected));
  }

  @Override
  public void setToggleGroup(UiToggleGroup group) {

    this.widget.setToggleGroup(((FxToggleGroup) group).getGroup());
  }

}
