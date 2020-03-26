/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;

/**
 * A normal window (no popup).
 */
public interface UiWindow extends UiChildWindow, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiWindow}.
   */
  static UiWindow of(UiContext context, UiRegularWidget... children) {

    UiWindow window = context.create(UiWindow.class);
    for (UiRegularWidget child : children) {
      window.addChild(child);
    }
    return window;
  }

}
