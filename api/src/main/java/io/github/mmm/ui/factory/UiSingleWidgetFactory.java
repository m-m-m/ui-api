/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiWidget;

/**
 * Factory for {@link io.github.mmm.ui.widget.UiWidget}s of a single type.
 *
 * @since 1.0.0
 * @param <W> the generic type of the {@link UiWidget} that is {@link #create(UiContext) created} by this factory.
 */
public interface UiSingleWidgetFactory<W extends UiWidget> {

  /**
   * This method creates a new {@link UiWidget} instance of the particular {@link UiWidget}-type managed by this
   * factory.
   *
   * @param context is the instance of {@link UiContext}.
   * @return the new {@link UiWidget}.
   */
  W create(UiContext context);

  /**
   * @return the {@link Class} this factory is responsible for.
   */
  Class<?> getType();

}
