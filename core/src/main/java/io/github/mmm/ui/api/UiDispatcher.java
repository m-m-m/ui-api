/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import java.util.concurrent.Callable;

import io.github.mmm.ui.impl.UiDispatcherProvider;

/**
 * This is the interface for the dispatcher of asynchronous processing.
 *
 * @see UiContext#getDispatcher()
 *
 * @since 1.0.0
 */
public interface UiDispatcher {

  /**
   * @return {@code true} if this method was invoked within the dispatcher thread of the underlying UI toolkit,
   *         {@code false} otherwise.
   */
  boolean isDispatchThread();

  /**
   * @param task is the job to {@link Runnable#run() invoke} within the {@link #isDispatchThread() UI dispatcher
   *        thread}. Should only do simple UI updates and then exit. In other words this method allows you do execute
   *        changes to the UI from any {@link Thread} of your application. It should be called from
   *        {@link #invokeAsynchron(Runnable) asynchronous tasks}.
   */
  void invokeUiTask(Runnable task);

  /**
   * This method {@link Runnable#run() invokes} the given {@code task} asynchronous in the dispatcher thread of the UI.
   * The term "asynchronous" means that this method may return before the <code>task</code> is invoked. If there is NO
   * dispatcher thread in the underlying UI implementation, the <code>task</code> may simply be invoked directly in the
   * implementation of this method.
   *
   * @param task is the job to {@link Runnable#run() invoke}.
   */
  void invokeAsynchron(Runnable task);

  /**
   * This method {@link Runnable#run() invokes} the given {@code task} once asynchronous after the given dalay.
   *
   * @param task is the job to {@link Runnable#run() invoke}.
   * @param delayMilliseconds is the delay in milliseconds when the {@code task} shall be executed.
   */
  void invokeTimer(Runnable task, int delayMilliseconds);

  /**
   * This method {@link Callable#call() invokes} the given {@code task} periodically. The first {@link Callable#call()
   * invocation} is performed after the given delay. Every time the {@code task} returns {@link Boolean#TRUE true},
   * another {@link Callable#call() invocation} is performed after the same delay until {@link Boolean#FALSE false} is
   * returned.
   *
   * @param task is the job to {@link Callable#call() invoke}.
   * @param delayMilliseconds is the periodically delay in milliseconds when the {@code task} shall be executed.
   */
  void invokeTimer(Callable<Boolean> task, int delayMilliseconds);

  /**
   * @return the instance of this {@link UiDispatcher}.
   */
  static UiDispatcher get() {

    return UiDispatcherProvider.DISPATCHER;
  }

}
