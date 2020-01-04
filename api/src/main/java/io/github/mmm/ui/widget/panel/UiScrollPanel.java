/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.datatype.UiScrolling;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.composite.UiMutableSingleComposite;

/**
 * {@link UiMutableSingleComposite} for a <em>scroll panel</em>.
 */
public interface UiScrollPanel extends UiMutableSingleComposite<UiRegularWidget>, UiNativeWidget {

  /**
   * @return the {@link UiScrolling} for the horizontal scrollbar.
   */
  UiScrolling getHorizontalScrolling();

  /**
   * @param scrolling the new {@link #getHorizontalScrolling() horizontal scrolling}.
   */
  void setHorizontalScrolling(UiScrolling scrolling);

  /**
   * @return the {@link UiScrolling} for the vertical scrollbar.
   */
  UiScrolling getVerticalScrolling();

  /**
   * @param scrolling the new {@link #getVerticalScrolling() vertical scrolling}.
   */
  void setVerticalScrolling(UiScrolling scrolling);

}
