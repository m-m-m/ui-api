/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.notifier;

import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.spi.ServiceHelper;

/**
 * Provider of {@link UiNotifier}.
 *
 * @since 1.0.0
 */
public final class UiNotifierProvider {

  /** The {@link UiNotifier#get() singleton instance} of {@link UiNotifier}. */
  public static final UiNotifier NOTIFIER = ServiceHelper.singleton(UiNotifier.class);

  private UiNotifierProvider() {

  }

}
