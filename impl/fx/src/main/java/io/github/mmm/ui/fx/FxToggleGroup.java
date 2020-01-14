/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.UiToggleGroup;
import javafx.scene.control.ToggleGroup;

/**
 * Implementation of {@link UiToggleGroup} for JavaFx using {@link ToggleGroup}.
 *
 * @since 1.0.0
 */
public class FxToggleGroup implements UiToggleGroup {

  private final ToggleGroup group;

  /**
   * The constructor.
   */
  public FxToggleGroup() {

    super();
    this.group = new ToggleGroup();
  }

  /**
   * @return the native JavaFx {@link ToggleGroup}.
   */
  public ToggleGroup getGroup() {

    return this.group;
  }

}
