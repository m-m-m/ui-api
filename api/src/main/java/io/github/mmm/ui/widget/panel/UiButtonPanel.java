/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.button.UiAbstractButton;

/**
 * {@link UiAbstractButtonContainer button container} showing a number of
 * {@link io.github.mmm.ui.widget.button.UiAbstractButton buttons} horizontally (e.g. "Save", "Reset", "Cancel"). It
 * shall be used instead of a generic panels to get control of the layout (margins) for button panels.
 *
 * @since 1.0.0
 */
public interface UiButtonPanel extends UiAbstractButtonContainer, UiRegularWidget, UiNativeWidget {

  /**
   * @param context the {@link UiContext}.
   * @return the new {@link UiButtonPanel}.
   */
  static UiButtonPanel of(UiContext context) {

    return context.create(UiButtonPanel.class);
  }

  /**
   * @param context the {@link UiContext}.
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiButtonPanel}.
   */
  static UiButtonPanel of(UiContext context, UiAbstractButton... children) {

    UiButtonPanel widget = context.create(UiButtonPanel.class);
    for (UiAbstractButton child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
