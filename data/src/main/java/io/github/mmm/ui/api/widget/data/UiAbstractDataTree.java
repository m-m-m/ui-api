/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.data;

import java.util.List;

/**
 * A {@link UiAbstractDataWidget} that presents its data as a tree of nodes that can be expanded and collapsed.
 *
 * @param <R> type of the tree nodes displayed as rows by this widget. Typically a {@link io.github.mmm.bean.Bean}.
 * @since 1.0.0
 */
public interface UiAbstractDataTree<R> extends UiAbstractDataWidget<R> {

  /**
   * @param model the {@link TreeModel} that has to be set to initialize this data tree. Should be set only once
   *        immediately after creation. If you want another {@link TreeModel} create a new tree widget.
   */
  void setTreeModel(TreeModel<R> model);

  /**
   * Model that adapts the tree structure.
   *
   * @param <D> type of the tree nodes as data model.
   */
  interface TreeModel<D> {

    /**
     * @return the root node of this {@link TreeModel}. In case you do not want to have a single root visible, you may
     *         return {@code null} here and have to accept {@code null} as argument to {@link #getChildren(Object)} to
     *         get the top-level nodes that will be displayed as children of a virtual and invisible root node.
     */
    D getRoot();

    /**
     * @param node the tree node to expand and get the children of.
     * @return the children of the given {@code node}. Should be {@link java.util.Collections#emptyList()} in case the
     *         given node is a leaf and has no children.
     */
    List<D> getChildren(D node);

    default void setParent(D node, D parent) {

      throw new UnsupportedOperationException();
    }

  }

}
