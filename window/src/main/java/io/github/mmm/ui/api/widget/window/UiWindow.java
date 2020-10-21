/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.window;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * A normal window (no popup).
 */
public interface UiWindow extends UiChildWindow, UiNativeWidget {

  /**
   * @param title the new {@link #getTitle() title} of the {@link UiWindow} to create.
   * @return the new {@link UiWindow}.
   */
  static UiWindow of(String title) {

    UiWindow window = UiWidgetFactoryNative.get().create(UiWindow.class);
    UiAbstractWindow.initTitle(window, title);
    return window;
  }

  /**
   * @param title the new {@link #getTitle() title} of the {@link UiWindow} to create.
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiWindow}.
   */
  static UiWindow of(String title, UiRegularWidget... children) {

    UiWindow window = of(title);
    for (UiRegularWidget child : children) {
      window.addChild(child);
    }
    return window;
  }

}
