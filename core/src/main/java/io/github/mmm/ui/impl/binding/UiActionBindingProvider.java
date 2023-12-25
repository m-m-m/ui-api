/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.binding;

import java.util.ServiceLoader;

import io.github.mmm.base.service.ServiceHelper;
import io.github.mmm.ui.api.binding.UiActionBinding;

/**
 * Provides the {@link UiActionBinding}.
 *
 * @since 1.0.0
 */
public final class UiActionBindingProvider {

  /** The {@link UiActionBinding#get() singleton instance} of {@link UiActionBinding}. */
  public static final UiActionBinding ACTION_BINDING = ServiceHelper
      .singleton(ServiceLoader.load(UiActionBinding.class));

  private UiActionBindingProvider() {

    super();
  }

}
