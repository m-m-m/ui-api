/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.controller;

import java.util.ServiceLoader;

import io.github.mmm.base.config.ServiceHelper;
import io.github.mmm.ui.api.controller.UiNavigationManager;

/**
 * Provider for {@link UiNavigationManager}.
 *
 * @since 1.0.0
 */
public class UiNavigationManagerProvider {

  /** The singleton instance. */
  public static final UiNavigationManager MANAGER = ServiceHelper
      .singleton(ServiceLoader.load(UiNavigationManager.class));

}
