/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.factory;

import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * Factory for {@link UiNativeWidget} of a single {@link #getType() type}.
 *
 * @param <W> the generic type of the {@link #getType() widget} to {@link #create() create}.
 * @since 1.0.0
 */
public interface UiSingleWidgetFactoryNative<W extends UiNativeWidget> extends UiSingleWidgetFactory<W> {

  /**
   * @return the {@link Class} reflecting the {@link UiNativeWidget} interface.
   */
  @Override
  Class<W> getType();

  /**
   * @see UiWidgetFactoryNative#create(Class, boolean)
   */
  @Override
  W create();

}
