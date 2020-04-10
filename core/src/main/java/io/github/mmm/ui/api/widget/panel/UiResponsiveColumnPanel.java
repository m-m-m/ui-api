/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;

/**
 * {@link UiMutableComposite} showing multiple {@link #getChild(int) children} as columns in a responsive layout. So
 * assuming your {@link io.github.mmm.ui.api.UiScreen screen} and window is wide enough, all {@link #getChild(int)
 * children} will be presented as columns from the left to the right. However if there is less
 * {@link io.github.mmm.ui.api.attribute.AttributeReadSize#getWidth() width} available, columns from the right will be
 * moved to the bottom to avoid horizontal scrolling. If there is only little width available (e.g. on a smart phone)
 * only one column will be available and all children will be displayed vertically from the top to the bottom. So in
 * other words this panel is a hybrid of {@link UiHorizontalPanel} with {@link UiVerticalPanel} that adapts dynamically
 * to the width available.
 *
 * @since 1.0.0
 */
public interface UiResponsiveColumnPanel extends UiMutableComposite<UiRegularWidget>, UiNativeWidget {

}
