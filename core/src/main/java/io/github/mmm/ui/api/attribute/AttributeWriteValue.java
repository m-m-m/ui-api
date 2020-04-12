/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getValue() read} and {@link #setValue(Object) write} a value.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface AttributeWriteValue<V> extends AttributeReadValue<V> {

  /**
   * @param value the {@link #getValue() value} to set.
   */
  void setValue(V value);

}
