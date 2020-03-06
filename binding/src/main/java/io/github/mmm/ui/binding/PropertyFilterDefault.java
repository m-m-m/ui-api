/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import io.github.mmm.entity.id.Id;
import io.github.mmm.entity.link.Link;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.property.container.ReadableContainerProperty;

/**
 * Default implementation of {@link PropertyFilter}.
 *
 * @since 1.0.0
 */
public class PropertyFilterDefault implements PropertyFilter {

  static final PropertyFilterDefault INSTANCE = new PropertyFilterDefault();

  @Override
  public boolean filter(ReadableProperty<?> property) {

    if (property instanceof ReadableContainerProperty) {
      return filter(((ReadableContainerProperty<?, ?>) property).getValueProperty());
    }
    Class<?> valueClass = property.getValueClass();
    if (Id.class.isAssignableFrom(valueClass)) {
      return true;
    } else if (Link.class.isAssignableFrom(valueClass)) {
      return true;
    }
    return false;
  }

}
