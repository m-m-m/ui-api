/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.composite;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.attribute.AttributeWriteClosable;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiActiveWidget;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * {@link UiMutableSingleComposite} that represents a single {@code tab}. It is a simple container for the actual widget
 * to show as content of the tab and also represents the tab from the header of the
 * {@link io.github.mmm.ui.api.widget.panel.UiTabPanel}.
 *
 * @see io.github.mmm.ui.api.widget.panel.UiTabPanel
 *
 * @since 1.0.0
 */
public interface UiTab extends UiMutableSingleComposite<UiRegularWidget>, AttributeWriteText, AttributeWriteClosable,
    UiActiveWidget, UiFailureComposite<UiRegularWidget>, UiNativeWidget { /* AttributeWriteImage<UiWidgetImage>, */

  @Override
  default void validateUp(UiValidState state) {

    if (state.isValid()) {
      setValidationFailure(null);
    } else {
      setValidationFailure(UiContext.get().getDefaultValidationFailure());
    }
    UiMutableSingleComposite.super.validateUp(state);
  }

  /**
   * @param text the {@link UiTab#getText() label text} of the {@link UiTab}.
   * @param child the {@link UiRegularWidget} to show as content if the {@link UiTab} is
   *        {@link io.github.mmm.ui.api.widget.panel.UiTabPanel#getActiveChild() active} (selected).
   * @return the new {@link UiTab}.
   */
  static UiTab of(String text, UiRegularWidget child) {

    UiTab widget = UiWidgetFactoryNative.get().create(UiTab.class);
    if (text != null) {
      widget.setText(text);
    }
    if (child != null) {
      widget.setChild(child);
    }
    return widget;
  }
}
