/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import java.util.concurrent.Callable;

import io.github.mmm.ui.spi.AbstractUiDispatcher;
import javafx.application.Platform;

/**
 * Implementation of {@link io.github.mmm.ui.UiDispatcher} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxDispatcher extends AbstractUiDispatcher {

  @Override
  public boolean isDispatchThread() {

    return Platform.isFxApplicationThread();
  }

  @Override
  public void invokeUiTask(Runnable task) {

    if (Platform.isFxApplicationThread()) {
      task.run();
    } else {
      Platform.runLater(task);
    }
  }

  @Override
  public void invokeAsynchron(Runnable task) {

    // TODO distinguish in API between long running background task, and UI task that should run later?
    Platform.runLater(task);
  }

  @Override
  public void invokeTimer(Runnable task, int delayMilliseconds) {

    // TODO Auto-generated method stub

  }

  @Override
  public void invokeTimer(Callable<Boolean> task, int delayMilliseconds) {

    // TODO Auto-generated method stub

  }

}
