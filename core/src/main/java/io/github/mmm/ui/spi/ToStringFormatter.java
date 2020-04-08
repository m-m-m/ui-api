/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import java.util.Objects;
import java.util.function.Function;

/**
 * Formatter {@link Function} that delegates to {@link Object#toString()}. This is used as default for
 * {@link io.github.mmm.ui.api.widget.input.UiAbstractChoice#getFormatter() formatter}.
 *
 * @param <V> type of the value to {@link #apply(Object) format}.
 * @since 1.0.0
 */
public final class ToStringFormatter<V> implements Function<V, String> {

  @SuppressWarnings("rawtypes")
  private static final ToStringFormatter INSTANCE = new ToStringFormatter<>();

  private ToStringFormatter() {

    super();
  }

  @Override
  public String apply(V t) {

    return Objects.toString(t);
  }

  /**
   * @param <V> type of the value to {@link #apply(Object) format}.
   * @return the singleton instance of {@link ToStringFormatter}.
   */
  public static <V> ToStringFormatter<V> get() {

    return INSTANCE;
  }

}
