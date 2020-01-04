/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} showing multiple {@link UiFormPanel} {@link #getChild(int) children} as columns in a
 * responsive layout.
 *
 * @since 1.0.0
 */
public interface UiResponsiveColumnPanel extends UiDynamicComposite<UiFormPanel>, UiNativeWidget {

}
