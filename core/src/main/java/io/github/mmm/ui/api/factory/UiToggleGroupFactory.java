/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.UiToggleGroup;

/**
 * Factory to create {@link UiToggleGroup}s.
 */
public interface UiToggleGroupFactory {

  /**
   * @return a new instance of {@link UiToggleGroup}.
   */
  UiToggleGroup create();

}
