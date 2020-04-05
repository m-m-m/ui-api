/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * Factory for {@link UiInput} for a single {@link #getType() datatype}.
 *
 * @param <V> is the generic type of the {@link #getType() datatype}.
 *
 * @since 1.0.0
 */
public interface UiSingleWidgetFactoryDatatype<V> extends UiSingleWidgetFactory<UiInput<V>> {

  /**
   * @return the {@link Class} reflecting the <em>datatype</em>. May be a standard datatype such as {@link String},
   *         {@link Long}, {@link java.time.LocalDateTime}, etc. or any custom datatype implementation including
   *         {@link Enum}s.
   */
  @Override
  Class<V> getType();

  /**
   * @see UiWidgetFactoryDatatype#create(Class, boolean, UiContext)
   * @see UiContext#createInput(Class)
   */
  @Override
  UiInput<V> create(UiContext context);

}
