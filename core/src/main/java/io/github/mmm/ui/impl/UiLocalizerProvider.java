/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl;

import java.util.ServiceLoader;

import io.github.mmm.base.config.ServiceHelper;
import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.UiLocalizer;

/**
 * Provides the {@link UiLocalizer}.
 *
 * @since 1.0.0
 */
public final class UiLocalizerProvider {

  /** The {@link UiContext#get() singleton instance} of {@link UiContext}. */
  public static final UiLocalizer LOCALIZER = ServiceHelper.singleton(ServiceLoader.load(UiLocalizer.class));

  private UiLocalizerProvider() {

    super();
  }

}
