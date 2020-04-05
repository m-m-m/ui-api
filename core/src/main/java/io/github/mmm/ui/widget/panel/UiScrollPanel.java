/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiScrollBarVisibility;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiMutableSingleComposite;

/**
 * {@link UiMutableSingleComposite} for a <em>scroll panel</em>.
 */
public interface UiScrollPanel extends UiMutableSingleComposite<UiRegularWidget>, UiRegularWidget, UiNativeWidget {

  /**
   * @return the {@link UiScrollBarVisibility} for the horizontal scrollbar.
   */
  UiScrollBarVisibility getHorizontalScrolling();

  /**
   * @param scrolling the new {@link #getHorizontalScrolling() horizontal scrolling}.
   */
  void setHorizontalScrolling(UiScrollBarVisibility scrolling);

  /**
   * @return the {@link UiScrollBarVisibility} for the vertical scrollbar.
   */
  UiScrollBarVisibility getVerticalScrolling();

  /**
   * @param scrolling the new {@link #getVerticalScrolling() vertical scrolling}.
   */
  void setVerticalScrolling(UiScrollBarVisibility scrolling);

  /**
   * @param context the {@link UiContext}.
   * @param child the {@link UiRegularWidget}s to {@link #setChild(UiRegularWidget) set as child}.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiScrollPanel of(UiContext context, UiRegularWidget child) {

    UiScrollPanel widget = context.create(UiScrollPanel.class);
    if (child != null) {
      widget.setChild(child);
    }
    return widget;
  }
}
