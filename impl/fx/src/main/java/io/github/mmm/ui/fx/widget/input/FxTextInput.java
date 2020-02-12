/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiTextInput;
import javafx.scene.control.TextField;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link TextField}.
 *
 * @since 1.0.0
 */
public class FxTextInput extends FxStringInput<TextField> implements UiTextInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxTextInput(UiContext context) {

    super(context, new TextField());
  }

}
