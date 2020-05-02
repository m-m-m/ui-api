/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.controller;

import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.api.controller.UiNavigationManager;

/**
 * Provider for {@link UiNavigationManager}.
 *
 * @since 1.0.0
 */
public class UiControllerManagerProvider {

  /** The singleton instance. */
  public static final UiControllerManagerProvider INSTANCE = new UiControllerManagerProvider();

  private final UiNavigationManager controllerManager;

  private UiControllerManagerProvider() {

    super();
    ServiceLoader<UiNavigationManager> serviceLoader = ServiceLoader.load(UiNavigationManager.class);
    UiNavigationManager cm = null;
    for (UiNavigationManager manager : serviceLoader) {
      if (cm == null) {
        cm = manager;
      } else {
        throw new DuplicateObjectException(manager, UiNavigationManager.class.getSimpleName(), cm);
      }
    }
    if (cm == null) {
      throw new ObjectNotFoundException(UiNavigationManager.class.getSimpleName());
    }
    this.controllerManager = cm;
  }

  /**
   * @return the {@link UiNavigationManager}.
   */
  public UiNavigationManager getControllerManager() {

    return this.controllerManager;
  }

}
