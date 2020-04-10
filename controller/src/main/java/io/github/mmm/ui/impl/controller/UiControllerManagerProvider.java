/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.controller;

import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.api.controller.UiControllerManager;

/**
 * Provider for {@link UiControllerManager}.
 *
 * @since 1.0.0
 */
public class UiControllerManagerProvider {

  /** The singleton instance. */
  public static final UiControllerManagerProvider INSTANCE = new UiControllerManagerProvider();

  private final UiControllerManager controllerManager;

  private UiControllerManagerProvider() {

    super();
    ServiceLoader<UiControllerManager> serviceLoader = ServiceLoader.load(UiControllerManager.class);
    UiControllerManager cm = null;
    for (UiControllerManager manager : serviceLoader) {
      if (cm == null) {
        cm = manager;
      } else {
        throw new DuplicateObjectException(manager, UiControllerManager.class.getSimpleName(), cm);
      }
    }
    if (cm == null) {
      throw new ObjectNotFoundException(UiControllerManager.class.getSimpleName());
    }
    this.controllerManager = cm;
  }

  /**
   * @return the {@link UiControllerManager}.
   */
  public UiControllerManager getControllerManager() {

    return this.controllerManager;
  }

}
