/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiHtmlEditor;
import javafx.scene.web.HTMLEditor;

/**
 * Implementation of {@link UiHtmlEditor} using JavaFx {@link HTMLEditor}.
 *
 * @since 1.0.0
 */
public class FxHtmlEditor extends FxInput<HTMLEditor, String> implements UiHtmlEditor {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxHtmlEditor(UiContext context) {

    super(context, new HTMLEditor());
  }

  @Override
  public String getValue() {

    return this.nativeWidget.getHtmlText();
  }

  @Override
  public void setValue(String value) {

    this.nativeWidget.setHtmlText(value);
  }

}
