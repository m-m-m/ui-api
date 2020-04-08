/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.data;

import io.github.mmm.property.ReadableProperty;

/**
 * Interface to {@link #filter(ReadableProperty) filter} {@link ReadableProperty properties} that should not be bound to
 * the UI.
 *
 * @since 1.0.0
 * @see UiDataBinding
 */
@FunctionalInterface
public interface PropertyFilter {

  /**
   * @param property the {@link ReadableProperty} to test.
   * @return {@code true} if the {@link ReadableProperty} should be filtered and ignored, {@code false} if the property
   *         should be bound to the UI.
   */
  boolean filter(ReadableProperty<?> property);

}
