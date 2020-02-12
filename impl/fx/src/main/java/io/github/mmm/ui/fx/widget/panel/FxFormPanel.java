/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.composite.FxDynamicComposite;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiVerticalPanel} using JavaFx {@link VBox}.
 *
 * @since 1.0.0
 */
public class FxFormPanel extends FxDynamicComposite<AdvancedGridPane, UiAbstractInput<?>> implements UiFormPanel {

  private String validationFailure;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxFormPanel(UiContext context) {

    super(context, new AdvancedGridPane());
  }

  @Override
  public void addChild(UiAbstractInput<?> child, int index) {

    int rows = this.children.size();
    if ((index < 0) || (index > rows)) {
      throw new IllegalArgumentException(Integer.toString(index));
    }
    setParent(child, this);
    UiLabel label = child.getNameWidget();
    if (index == rows) {
      this.widget.addRow(index, getTopNode(label), getTopNode(child));
    } else if (index < rows) {
      this.widget.insertRow(index, getTopNode(label), getTopNode(child));
    }
    this.children.add(index, child);
  }

  @Override
  public boolean removeChild(UiAbstractInput<?> child) {

    int index = this.children.indexOf(child);
    if (index < 0) {
      return false;
    }
    removeChild(index);
    return true;
  }

  @Override
  public UiAbstractInput<?> removeChild(int index) {

    UiAbstractInput<?> child = this.children.remove(index);
    this.widget.removeRow(index);
    setParent(child, null);
    return child;
  }

  @Override
  public String getValidationFailure() {

    return this.validationFailure;
  }

  @Override
  public void setValidationFailure(String validationFailure) {

    boolean invalid = !isEmpty(validationFailure);
    if (invalid) {
      this.validationFailure = validationFailure;
      getStyles().add(STYLE_INVALID);
    } else {
      this.validationFailure = null;
      getStyles().remove(STYLE_INVALID);
    }
    // TODO apply validationFailure to widget!
  }

}
