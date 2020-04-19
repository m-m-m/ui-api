/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.notifier;

import java.util.ServiceLoader;

import io.github.mmm.base.config.ServiceHelper;
import io.github.mmm.ui.api.notifier.UiNotifier;

/**
 * Provider of {@link UiNotifier}.
 *
 * @since 1.0.0
 */
public final class UiNotifierProvider {

  /** The {@link UiNotifier#get() singleton instance} of {@link UiNotifier}. */
  public static final UiNotifier NOTIFIER = ServiceHelper.singleton(ServiceLoader.load(UiNotifier.class));

  private UiNotifierProvider() {

  }

}
