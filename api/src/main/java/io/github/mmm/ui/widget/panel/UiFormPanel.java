/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.panel;

import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.composite.UiDynamicComposite;
import io.github.mmm.ui.widget.input.UiInput;

/**
 * {@link UiDynamicComposite} for a form of {@link UiInput}s as {@link #getChild(int) children} shown vertically from
 * the top to the bottom.
 *
 * @since 1.0.0
 */
public interface UiFormPanel extends UiDynamicComposite<UiInput<?>>, UiNativeWidget {

}
