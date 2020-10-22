/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;

/**
 * {@link UiAbstractButtonContainer button container} showing a number of
 * {@link io.github.mmm.ui.api.widget.button.UiAbstractButton buttons} horizontally (e.g. "Save", "Reset", "Cancel"). It
 * shall be used instead of a generic panels to get control of the layout (margins) for button panels.
 *
 * @since 1.0.0
 */
public interface UiButtonPanel extends UiAbstractButtonContainer, UiRegularWidget, UiNativeWidget {

  /** The {@link io.github.mmm.ui.api.datatype.UiStyles#add(String) style} or element name of this widget. */
  String STYLE = "ui-buttons";

  /**
   * @return the new {@link UiButtonPanel}.
   */
  static UiButtonPanel of() {

    return UiWidgetFactoryNative.get().create(UiButtonPanel.class);
  }

  /**
   * @param children the {@link UiRegularWidget}s to add as children.
   * @return the new {@link UiButtonPanel}.
   */
  static UiButtonPanel of(UiAbstractButton... children) {

    UiButtonPanel widget = of();
    for (UiAbstractButton child : children) {
      widget.addChild(child);
    }
    return widget;
  }

}
