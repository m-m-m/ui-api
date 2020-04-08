/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiDynamicPanel} that shows its {@link #getChild(int) children} horizontally from the left to the right.
 *
 * @since 1.0.0
 */
public interface UiHorizontalPanel extends UiDynamicPanel, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @return the new {@link UiHorizontalPanel}.
   */
  static UiHorizontalPanel of(UiContext context) {

    return context.create(UiHorizontalPanel.class);
  }

  /**
   * @param context the {@link UiContext}.
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiHorizontalPanel of(UiContext context, UiRegularWidget... children) {

    UiHorizontalPanel widget = context.create(UiHorizontalPanel.class);
    for (UiRegularWidget child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
