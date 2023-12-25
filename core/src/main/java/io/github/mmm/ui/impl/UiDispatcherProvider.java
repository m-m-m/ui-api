/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl;

import java.util.ServiceLoader;

import io.github.mmm.base.service.ServiceHelper;
import io.github.mmm.ui.api.UiDispatcher;

/**
 * Provides the {@link UiDispatcher}.
 *
 * @since 1.0.0
 */
public final class UiDispatcherProvider {

  /** The {@link UiDispatcher#get() singleton instance} of {@link UiDispatcher}. */
  public static final UiDispatcher DISPATCHER = ServiceHelper.singleton(ServiceLoader.load(UiDispatcher.class));

  private UiDispatcherProvider() {

    super();
  }

}
