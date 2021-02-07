/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.data;

import java.util.stream.Stream;

import io.github.mmm.bean.ReadableBean;
import io.github.mmm.entity.id.Id;
import io.github.mmm.entity.link.Link;
import io.github.mmm.property.ReadableProperty;

/**
 * Default implementation of {@link PropertyProvider}.
 *
 * @since 1.0.0
 */
public class PropertyProviderDefault implements PropertyProvider {

  static final PropertyProviderDefault INSTANCE = new PropertyProviderDefault();

  @Override
  public Stream<? extends ReadableProperty<?>> get(ReadableBean bean) {

    return bean.getProperties().stream().filter(this::accept);
  }

  /**
   * @param property the {@link ReadableProperty} to check.
   * @return {@code true} to accept the given {@code property}, {@code false} to exclude it.
   */
  protected boolean accept(ReadableProperty<?> property) {

    Class<?> valueClass = property.getValueClass();
    if (Id.class.isAssignableFrom(valueClass)) {
      return true;
    } else if (Link.class.isAssignableFrom(valueClass)) {
      return true;
    }
    return true;
  }

}
