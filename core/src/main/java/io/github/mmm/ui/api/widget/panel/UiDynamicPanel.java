/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiDynamicComposite;

/**
 * {@link UiDynamicComposite} for a generic panel that accepts any {@link UiRegularWidget} as {@link #getChild(int)
 * child}.
 *
 * @since 1.0.0
 */
public abstract interface UiDynamicPanel extends UiDynamicComposite<UiRegularWidget>, UiRegularWidget {

}
