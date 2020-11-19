/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import io.github.mmm.ui.api.UiToggleGroup;

/**
 * Interface to {@link #getToggleGroup() read} and {@link #setToggleGroup(UiToggleGroup) write} the
 * {@link UiToggleGroup}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeWriteToggleGroup {

  /**
   * @return he {@link UiToggleGroup} that combines multiple
   *         {@link io.github.mmm.ui.api.widget.value.UiAbstractRadioButton radio buttons} so that only one out of the
   *         group can be selected.
   */
  UiToggleGroup getToggleGroup();

  /**
   * @param group the new {@link #getToggleGroup() toggle group}.
   */
  void setToggleGroup(UiToggleGroup group);

}
