/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextArea;
import javafx.scene.control.TextArea;

/**
 * Implementation of {@link UiTextArea} using JavaFx {@link TextArea}.
 *
 * @since 1.0.0
 */
public class FxTextArea extends FxStringInput<TextArea> implements UiTextArea {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxTextArea(UiContext context) {

    super(context, new TextArea());
  }

}
