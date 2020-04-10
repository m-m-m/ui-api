/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.menu;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractMenuItem} that acts as a <em>separator</em>. A separator is visualized as a line that separates
 * other {@link UiAbstractMenuItem}s. It has no further functionality.
 *
 * @since 1.0.0
 */
public interface UiMenuItemSeparator extends UiAbstractMenuItem, UiNativeWidget {

  /**
   * @return the new {@link UiMenuItemSeparator}.
   */
  static UiMenuItemSeparator of() {

    return UiWidgetFactoryNative.get().create(UiMenuItemSeparator.class);
  }
}
