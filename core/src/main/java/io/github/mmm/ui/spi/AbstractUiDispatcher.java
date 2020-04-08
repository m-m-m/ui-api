/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import io.github.mmm.ui.api.UiDispatcher;

/**
 * Abstract base implementation of {@link UiDispatcher}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiDispatcher implements UiDispatcher {

  /**
   * The constructor.
   */
  public AbstractUiDispatcher() {

    super();
  }

  @Override
  public void invokeUiTask(Runnable task) {

    task.run();
  }

}
