/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import io.github.mmm.ui.api.widget.input.UiRadioButton;
import io.github.mmm.ui.impl.UiToggleGroupFactoryProvider;

/**
 * This is a logical group that combines multiple {@link io.github.mmm.ui.api.widget.UiWidget}s such as
 * {@link UiRadioButton}s so that only one of them can be selected at a time.
 *
 * @see #of()
 */
public interface UiToggleGroup {

  /**
   * @return the native toggle group from the underlying toolkit.
   */
  Object getGroup();

  /**
   * @return a new instance of {@link UiToggleGroup}.
   */
  static UiToggleGroup of() {

    return UiToggleGroupFactoryProvider.FACTORY.create();
  }

}
