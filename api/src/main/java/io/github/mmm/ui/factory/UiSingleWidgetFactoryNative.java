/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.factory;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Factory for {@link UiNativeWidget} of a single {@link #getWidgetInterface() type}.
 *
 * @param <W> the generic type of the {@link #getWidgetInterface() widget} to {@link #create(UiContext) create}.
 * @since 1.0.0
 */
public interface UiSingleWidgetFactoryNative<W extends UiNativeWidget> extends UiSingleWidgetFactory<W> {

  /**
   * @return the {@link Class} reflecting the {@link UiNativeWidget} interface.
   */
  Class<W> getWidgetInterface();

}
