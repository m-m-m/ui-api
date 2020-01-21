/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import io.github.mmm.ui.UiToggleGroup;

/**
 * Implementation of {@link UiToggleGroup} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmToggleGroup implements UiToggleGroup {

  private static int counter = 1;

  private final String name;

  /**
   * The constructor.
   */
  public TvmToggleGroup() {

    super();
    this.name = "radio" + counter++;
  }

  @Override
  public String getGroup() {

    return this.name;
  }

  @Override
  public String toString() {

    return this.name;
  }

}
