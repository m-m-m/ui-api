/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import java.util.concurrent.Callable;

import org.teavm.jso.browser.TimerHandler;
import org.teavm.jso.browser.Window;

import io.github.mmm.ui.spi.AbstractUiDispatcher;

/**
 *
 */
public class TvmDispatcher extends AbstractUiDispatcher {

  @Override
  public boolean isDispatchThread() {

    return true;
  }

  @Override
  public void invokeAsynchron(Runnable task) {

    // TODO Auto-generated method stub

  }

  @Override
  public void invokeTimer(Runnable task, int delayMilliseconds) {

    TimerHandler timer = () -> task.run();
    Window.setTimeout(timer, delayMilliseconds);
  }

  @Override
  public void invokeTimer(Callable<Boolean> task, int delayMilliseconds) {

    RepeatingTimer timer = new RepeatingTimer(task);
    timer.intervalId = Window.setInterval(timer, delayMilliseconds);
  }

  private static class RepeatingTimer implements TimerHandler {

    private final Callable<Boolean> task;

    private int intervalId;

    public RepeatingTimer(Callable<Boolean> task) {

      super();
      this.task = task;
    }

    @Override
    public void onTimer() {

      try {
        Boolean repeat = this.task.call();
        if (!Boolean.TRUE.equals(repeat)) {
          Window.clearInterval(this.intervalId);
        }
      } catch (Exception e) {
        Window.clearInterval(this.intervalId);
        // e.printStackTrace();
      }
    }

  }

}
