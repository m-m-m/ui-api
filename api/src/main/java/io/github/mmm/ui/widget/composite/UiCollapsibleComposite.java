/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.composite;

import io.github.mmm.ui.attribute.AttributeWriteCollapsible;
import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiDynamicComposite} that allows to {@link #setCollapsed(boolean) collapse and expand} its
 * {@link #getChild(int) children}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public interface UiCollapsibleComposite<C extends UiWidget> extends UiDynamicComposite<C>, AttributeWriteCollapsible {

}
