/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl;

import java.util.ServiceLoader;

import io.github.mmm.base.service.ServiceHelper;
import io.github.mmm.ui.api.UiScreen;

/**
 * Provides the {@link UiScreen}.
 *
 * @since 1.0.0
 */
public final class UiScreenProvider {

  /** The {@link UiScreen#get() singleton instance} of {@link UiScreen}. */
  public static final UiScreen SCREEN = ServiceHelper.singleton(ServiceLoader.load(UiScreen.class));

  private UiScreenProvider() {

    super();
  }

}
