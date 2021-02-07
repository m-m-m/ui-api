/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.data;

import java.util.stream.Stream;

import io.github.mmm.bean.ReadableBean;
import io.github.mmm.property.ReadableProperty;

/**
 * Interface to {@link #get(ReadableBean) get} the {@link ReadableProperty properties} of a {@link ReadableBean} that
 * should be bound to the UI. Allows to filter technical properties that should not be visible in the UI as well as to
 * influence the order in which the properties should appear in the editor form.
 *
 * @since 1.0.0
 * @see UiDataBinding
 */
@FunctionalInterface
public interface PropertyProvider {

  /**
   * @param bean the {@link ReadableBean} to get the properties to bind.
   * @return a {@link Stream} with the {@link ReadableProperty properties} of the given {@link ReadableBean bean} that
   *         should be bound to the UI. Allows to filter and sort properties specific to the UI.
   */
  Stream<? extends ReadableProperty<?>> get(ReadableBean bean);

}
