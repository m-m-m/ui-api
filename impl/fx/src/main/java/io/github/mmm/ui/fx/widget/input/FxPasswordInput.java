/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiPasswordInput;
import javafx.scene.control.PasswordField;

/**
 * Implementation of {@link UiPasswordInput} using JavaFx {@link PasswordField}.
 *
 * @since 1.0.0
 */
public class FxPasswordInput extends FxStringInput<PasswordField> implements UiPasswordInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxPasswordInput(UiContext context) {

    super(context, new PasswordField());
  }

}
