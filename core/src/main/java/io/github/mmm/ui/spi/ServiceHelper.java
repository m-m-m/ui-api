/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;

/**
 * Helper class for {@link ServiceLoader}.
 */
public final class ServiceHelper {

  private ServiceHelper() {

  }

  /**
   * @param <S> type of the service.
   * @param type the {@link Class} reflecting the service.
   * @return the requested service.
   */
  public static final <S> S singleton(Class<S> type) {

    return singleton(type, true);
  }

  /**
   * @param <S> type of the service.
   * @param type the {@link Class} reflecting the service.
   * @param unique - {@code true} if an exception is thrown if the service is not unique, {@code false} otherwise (allow
   *        overriding default).
   * @return the requested service.
   */
  public static final <S> S singleton(Class<S> type, boolean unique) {

    ServiceLoader<S> serviceLoader = ServiceLoader.load(type);
    S service = null;
    for (S currentService : serviceLoader) {
      if (service == null) {
        service = currentService;
      } else {
        if (unique) {
          throw new DuplicateObjectException(currentService, type, service);
        } else if (!currentService.getClass().getName().startsWith("io.github.mmm.")) {
          service = currentService;
        }
      }
    }
    if (service == null) {
      throw new ObjectNotFoundException(type);
    }
    return service;
  }

}
