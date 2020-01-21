/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.widget.UiActiveWidget;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithClosable;
import io.github.mmm.ui.widget.attribute.UiWidgetWithLabel;

/**
 * {@link UiMutableSingleComposite} that represents a single {@code tab}. It is a simple container for the actual widget
 * to show as content of the tab and also represents the tab from the header of the
 * {@link io.github.mmm.ui.widget.panel.UiTabPanel}.
 *
 * @see io.github.mmm.ui.widget.panel.UiTabPanel
 *
 * @since 1.0.0
 */
public interface UiTab extends UiMutableSingleComposite<UiRegularWidget>, UiWidgetWithLabel, UiWidgetWithClosable,
    UiActiveWidget, UiNativeWidget { /* AttributeWriteImage<UiWidgetImage>, */

}
