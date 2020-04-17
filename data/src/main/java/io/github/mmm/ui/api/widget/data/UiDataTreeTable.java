/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.data;

import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * A {@link UiAbstractDataWidget} that presents its data as a tree of nodes that can be expanded and collapsed.
 *
 * @param <D> type of the data model for the rows displayed by this widget. Typically a {@link io.github.mmm.bean.Bean}.
 * @since 1.0.0
 */
public interface UiDataTreeTable<D> extends UiAbstractDataTree<D>, UiAbstractDataTable<D>, UiNativeWidget {

}
