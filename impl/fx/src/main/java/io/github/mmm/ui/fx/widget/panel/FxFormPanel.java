/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import javafx.scene.Node;

/**
 * Implementation of {@link UiFormPanel} using JavaFx.
 *
 * @since 1.0.0
 */
public class FxFormPanel extends FxFailureComposite<AdvancedGridPane, UiAbstractInput<?>> implements UiFormPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxFormPanel(UiContext context) {

    super(context, new AdvancedGridPane());
  }

  @Override
  protected void addChildWidget(UiAbstractInput<?> child, int index) {

    int rows = this.children.size();
    Node[] childNodes;
    if (child instanceof UiInput) {
      UiInput<?> input = (UiInput<?>) child;
      UiLabel label = input.getNameWidget();
      childNodes = new Node[] { getTopNode(label), getTopNode(child) };
    } else {
      childNodes = new Node[] { getTopNode(child) };
    }
    if ((index == -1) || (index == rows)) {
      this.widget.addRow(rows, childNodes);
    } else if (index < rows) {
      this.widget.insertRow(index, childNodes);
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractInput<?> child, int index) {

    this.widget.removeRow(index);
  }

}
