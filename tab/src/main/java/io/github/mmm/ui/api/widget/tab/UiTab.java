/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.tab;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.attribute.AttributeWriteClosable;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.widget.UiActiveWidget;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiFailureComposite;
import io.github.mmm.ui.api.widget.composite.UiMutableSingleComposite;

/**
 * {@link UiMutableSingleComposite} that represents a single {@code tab}. It is a simple container for the actual widget
 * to show as content of the tab and also represents the tab from the header of the
 * {@link io.github.mmm.ui.api.widget.tab.UiTabPanel}.<br>
 * A {@link UiTab} is not a {@link UiNativeWidget} and has to be created via
 * {@link io.github.mmm.ui.api.widget.tab.UiTabPanel#addTab(String, UiRegularWidget)}.
 *
 * @see io.github.mmm.ui.api.widget.tab.UiTabPanel
 *
 * @since 1.0.0
 */
public interface UiTab extends UiMutableSingleComposite<UiRegularWidget>, AttributeWriteText, AttributeWriteClosable,
    UiActiveWidget, UiFailureComposite<UiRegularWidget> { /* AttributeWriteImage<UiWidgetImage>, */

  @Override
  default void validateUp(UiValidState state) {

    if (state.isValid()) {
      setValidationFailure(null);
    } else {
      setValidationFailure(UiContext.get().getDefaultValidationFailure());
    }
    UiMutableSingleComposite.super.validateUp(state);
  }

}
