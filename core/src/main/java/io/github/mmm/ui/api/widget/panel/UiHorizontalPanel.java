/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiMutablePanel} that shows its {@link #getChild(int) children} horizontally from the left to the right.
 *
 * @since 1.0.0
 */
public interface UiHorizontalPanel extends UiMutablePanel, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name this widget. */
  String STYLE = "ui-hpanel";

  /**
   * @return the new {@link UiHorizontalPanel}.
   */
  static UiHorizontalPanel of() {

    return UiWidgetFactoryNative.get().create(UiHorizontalPanel.class);
  }

  /**
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiHorizontalPanel of(UiRegularWidget... children) {

    UiHorizontalPanel widget = of();
    for (UiRegularWidget child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
