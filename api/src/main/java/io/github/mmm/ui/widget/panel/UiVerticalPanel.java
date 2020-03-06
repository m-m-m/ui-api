/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;

/**
 * {@link UiDynamicPanel} that shows its {@link #getChild(int) children} vertically from the top to the bottom.
 *
 * @since 1.0.0
 */
public interface UiVerticalPanel extends UiDynamicPanel, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiVerticalPanel of(UiContext context) {

    return context.create(UiVerticalPanel.class);
  }

  /**
   * @param context the {@link UiContext}.
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiVerticalPanel of(UiContext context, UiRegularWidget... children) {

    UiVerticalPanel widget = context.create(UiVerticalPanel.class);
    for (UiRegularWidget child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
