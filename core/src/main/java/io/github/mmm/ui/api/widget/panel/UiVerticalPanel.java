/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiMutablePanel} that shows its {@link #getChild(int) children} vertically from the top to the bottom.
 *
 * @since 1.0.0
 */
public interface UiVerticalPanel extends UiMutablePanel, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name of this widget. */
  String STYLE = "ui-vpanel";

  /**
   * @return the new {@link UiVerticalPanel}.
   */
  static UiVerticalPanel of() {

    return UiWidgetFactoryNative.get().create(UiVerticalPanel.class);
  }

  /**
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiVerticalPanel}.
   */
  static UiVerticalPanel of(UiRegularWidget... children) {

    UiVerticalPanel widget = of();
    for (UiRegularWidget child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
