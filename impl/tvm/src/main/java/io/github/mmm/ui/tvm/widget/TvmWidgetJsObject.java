/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLInputElement;
import org.teavm.jso.dom.html.HTMLSelectElement;
import org.teavm.jso.dom.html.HTMLTextAreaElement;
import org.teavm.jso.dom.xml.Document;
import org.teavm.jso.dom.xml.Node;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEvent;
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

  /** The owner {@link Document} of the HTML. */
  protected static final Document DOC = Window.current().getDocument();

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_ARIA_HIDDEN = "aria-hidden";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_ARIA_SELECTED = "aria-selected";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_TABINDEX = "tabindex";

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
   * @param event the click {@link Event}.
   */
  protected void onClick(Event event) {

    fireEvent(new UiClickEvent(this, false));
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

  /**
   * @return a new {@link HTMLButtonElement}.
   */
  protected static HTMLButtonElement newButton() {

    return DOC.createElement("button").cast();
  }

  /**
   * @return a new {@link HTMLInputElement}.
   */
  protected static HTMLInputElement newInput() {

    return DOC.createElement("input").cast();
  }

  /**
   * @param type the {@link HTMLInputElement#getType() input type}.
   * @return a new {@link HTMLInputElement}.
   */
  protected static HTMLInputElement newInput(String type) {

    HTMLInputElement input = newInput();
    input.setType(type);
    return input;
  }

  /**
   * @return a new {@link HTMLTextAreaElement}.
   */
  protected static HTMLTextAreaElement newTextArea() {

    return DOC.createElement("textarea").cast();
  }

  /**
   * @return a new {@link HTMLSelectElement}.
   */
  protected static HTMLSelectElement newSelect() {

    return DOC.createElement("select").cast();
  }

  /**
   * @return a new {@link HTMLElement label element}.
   */
  protected static HTMLElement newLabel() {

    return DOC.createElement("label").cast();
  }

  /**
   * @return a new {@link HTMLElement div element}.
   */
  protected static HTMLElement newDiv() {

    return DOC.createElement("div").cast();
  }

  /**
   * @return a new {@link HTMLElement span element}.
   */
  protected static HTMLElement newSpan() {

    return DOC.createElement("span").cast();
  }

  /**
   * @param tag the {@link HTMLElement#getTagName() tag name}.
   * @return a new {@link HTMLElement div element}.
   */
  protected static HTMLElement newElement(String tag) {

    return DOC.createElement(tag).cast();
  }

}
