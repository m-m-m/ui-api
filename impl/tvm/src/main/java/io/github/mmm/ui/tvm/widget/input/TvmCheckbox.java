/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiCheckbox;

/**
 * Implementation of {@link UiCheckbox} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmCheckbox extends TvmBooleanInput implements UiCheckbox {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmCheckbox(UiContext context) {

    super(context, TYPE_CHECKBOX, "ui-checkbox");
  }

}
