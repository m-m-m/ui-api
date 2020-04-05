/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteClosable;
import io.github.mmm.ui.attribute.AttributeWriteText;
import io.github.mmm.ui.datatype.UiValidState;
import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;

/**
 * {@link UiMutableSingleComposite} that represents a single {@code tab}. It is a simple container for the actual widget
 * to show as content of the tab and also represents the tab from the header of the
 * {@link io.github.mmm.ui.widget.panel.UiTabPanel}.
 *
 * @see io.github.mmm.ui.widget.panel.UiTabPanel
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
      setValidationFailure(getContext().getDefaultValidationFailure());
    }
    UiMutableSingleComposite.super.validateUp(state);
  }

  /**
   * @param context the {@link UiContext}.
   * @param child the {@link UiRegularWidget} to show as content if the {@link UiTab} is
   *        {@link io.github.mmm.ui.widget.panel.UiTabPanel#getActiveChild() active} (selected).
   * @param label the {@link UiTab#getText() label} of the {@link UiTab}.
   * @return the new {@link UiTab}.
   */
  static UiTab of(UiContext context, UiRegularWidget child, String label) {

    UiTab widget = context.create(UiTab.class);
    widget.setText(label);
    widget.setChild(child);
    return widget;
  }
}
