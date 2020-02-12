/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.JSObject;
import org.teavm.jso.dom.xml.Node;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.widget.AbstractUiNativeWidgetWrapper;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.custom.UiCustomWidget;

/**
 * Implementation of {@link io.github.mmm.ui.widget.UiNativeWidget} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmWidgetJsObject<W extends JSObject> extends AbstractUiNativeWidgetWrapper<W> {

  /** @see #getWidget() */
  protected final W widget;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmWidgetJsObject(UiContext context, W widget) {

    super(context);
    this.widget = widget;
  }

  @Override
  public JSObject getTopWidget() {

    return this.widget;
  }

  @Override
  public W getWidget() {

    return this.widget;
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

  /**
   * @param node the {@link Node} to remove all children from.
   */
  protected static void removeAllChildren(Node node) {

    Node firstChild = node.getFirstChild();
    while (firstChild != null) {
      node.removeChild(firstChild);
      firstChild = node.getFirstChild();
    }
  }

  /**
   * @param uiWidget the {@link UiWidget}.
   * @return the {@link #getWidget() containing} JavaFx {@link Node}.
   */
  protected static Node getTopNode(UiWidget uiWidget) {

    if (uiWidget instanceof UiCustomWidget) {
      getTopNode(((UiCustomWidget<?>) uiWidget).getDelegate());
    }
    return ((TvmWidgetHtmlElement<?>) uiWidget).getTopWidget();
  }

  /**
   * @param parent the parent {@link Node}.
   * @param child the child {@link Node} to insert as first child.
   */
  protected static void insertFirst(Node parent, Node child) {

    Node firstChild = parent.getFirstChild();
    if (firstChild == null) {
      parent.appendChild(child);
    } else {
      parent.insertBefore(child, firstChild);
    }
  }

  /**
   * @param parent the parent {@link Node}.
   * @param child the child {@link Node} to insert as child at the given index.
   * @param index the position to insert the {@code child} at.
   */
  protected static void insertAt(Node parent, Node child, int index) {

    if (index == 0) {
      insertFirst(parent, child);
    }
    int i = 0;
    Node node = parent.getFirstChild();
    while ((node != null) && (i < index)) {
      node = node.getNextSibling();
      i++;
    }
    if (node == null) {
      if (i == index) {
        parent.appendChild(child);
      } else {
        throw new IllegalArgumentException(Integer.toString(index));
      }
    } else {
      parent.insertBefore(child, node);
    }
  }

}
