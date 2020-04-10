/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.impl.binding;

import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.spi.ServiceHelper;

/**
 * Provides the {@link UiActionBinding}.
 *
 * @since 1.0.0
 */
public final class UiActionBindingProvider {

  /** The {@link UiActionBinding#get() singleton instance} of {@link UiActionBinding}. */
  public static final UiActionBinding ACTION_BINDING = ServiceHelper.singleton(UiActionBinding.class);

  private UiActionBindingProvider() {

    super();
  }

}
