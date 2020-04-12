/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiCollapsibleComposite;

/**
 * {@link UiCollapsibleComposite Collapsible} {@link UiMutablePanel panel} as {@link UiNativeWidget native widget}.
 * Allows to {@link #setCollapsed(boolean) collapse and expand} its {@link #getChild(int) children} that are layed out
 * vertically. The title of the top-bar to collaps/expand is set via {@link #setText(String)}.
 *
 * @since 1.0.0
 */
public interface UiCollapsiblePanel
    extends UiCollapsibleComposite<UiRegularWidget>, UiMutablePanel, AttributeWriteText, UiNativeWidget {

  /**
   * @return the new {@link UiCollapsiblePanel}.
   */
  static UiCollapsiblePanel of() {

    return UiWidgetFactoryNative.get().create(UiCollapsiblePanel.class);
  }

  /**
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiCollapsiblePanel}.
   */
  static UiCollapsiblePanel of(UiRegularWidget... children) {

    UiCollapsiblePanel widget = of();
    for (UiRegularWidget child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
