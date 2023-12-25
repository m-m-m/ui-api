/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl;

import java.util.ServiceLoader;

import io.github.mmm.base.service.ServiceHelper;
import io.github.mmm.ui.api.factory.UiToggleGroupFactory;

/**
 * Provides the {@link UiToggleGroupFactory}.
 *
 * @since 1.0.0
 */
public final class UiToggleGroupFactoryProvider {

  /** The singleton instance of {@link UiToggleGroupFactory}. */
  public static final UiToggleGroupFactory FACTORY = ServiceHelper
      .singleton(ServiceLoader.load(UiToggleGroupFactory.class));

  private UiToggleGroupFactoryProvider() {

    super();
  }

}
