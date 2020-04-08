/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getValue() read} and {@link #setValue(Object, boolean) write} a value.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public interface AttributeWriteValueForUser<V> extends AttributeReadValue<V> {

  /**
   * @param value the {@link #getValue() value} to set.
   * @param forUser - {@code true} to {@link io.github.mmm.ui.api.widget.value.UiValidatableWidget#setValueForUser(Object)
   *        set the value on behalf of the end-user}, {@code false} otherwise (to set programmatically).
   */
  void setValue(V value, boolean forUser);

}
