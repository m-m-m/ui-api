/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget;

import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLAudioElement;
import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLFormElement;
import org.teavm.jso.dom.html.HTMLInputElement;
import org.teavm.jso.dom.html.HTMLSelectElement;
import org.teavm.jso.dom.html.HTMLTextAreaElement;
import org.teavm.jso.dom.html.HTMLVideoElement;
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
  protected static final HTMLDocument DOC = Window.current().getDocument();

  /** {@link HTMLElement#getTagName() Tag name} of UI icon. */
  protected static final String TAG_NAME_UI_ICON = "ui-icon";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_ROLE = "role";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_ARIA_HIDDEN = "aria-hidden";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_ARIA_SELECTED = "aria-selected";

  /** {@link HTMLElement#getAttribute(String) Attribute name} {@value}. */
  protected static final String ATR_TABINDEX = "tabindex";

  /** {@link org.teavm.jso.dom.events.Event#getType() Event type} {@value}. */
  protected static final String EVENT_TYPE_BLUR = "blur";

  /** {@link org.teavm.jso.dom.events.Event#getType() Event type} {@value}. */
  protected static final String EVENT_TYPE_FOCUS = "focus";

  /** {@link org.teavm.jso.dom.events.Event#getType() Event type} {@value}. */
  protected static final String EVENT_TYPE_CLICK = "click";

  /** {@link org.teavm.jso.dom.events.Event#getType() Event type} {@value}. */
  protected static final String EVENT_TYPE_INPUT = "input";

  /** {@link org.teavm.jso.dom.events.Event#getType() Event type} {@value}. */
  protected static final String EVENT_TYPE_KEYDOWN = "keydown";

  /** {@link HTMLElement#getClassName() CSS class name} for error icon. */
  protected static final String CLASS_ERROR = "error";

  /** {@link HTMLElement#getClassName() CSS class name} for warning icon. */
  protected static final String CLASS_WARNING = "warning";

  /** {@link HTMLElement#getClassName() CSS class name} for info icon. */
  protected static final String CLASS_INFO = "info";

  /** {@link HTMLElement#getClassName() CSS class name} for expand icon. */
  protected static final String CLASS_EXPAND = "expand";

  /** {@link HTMLElement#getClassName() CSS class name} for collapse icon. */
  protected static final String CLASS_COLLAPSE = "collapse";

  /** {@link HTMLElement#getClassName() CSS class name} for question icon. */
  protected static final String CLASS_QUESTION = "question";

  /** CSS style for a collapsed widget (hiding its children). */
  protected static final String STYLE_COLLAPSED = "collapsed";

  /** CSS style for a collapsible widget (can be collapsed/expanded by the end-user). */
  protected static final String STYLE_COLLAPSIBLE = "collapsible";

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
   * @param child the child {@link Node} to insert as child at the given index. May be {@code -1} to
   *        {@link Node#appendChild(Node) insert at the end}.
   * @param index the position to insert the {@code child} at.
   */
  protected static void insertAt(Node parent, Node child, int index) {

    if (index == 0) {
      insertFirst(parent, child);
    }
    int i = 0;
    Node node = null;
    if (index > 0) {
      node = parent.getFirstChild();
      while ((node != null) && (i < index)) {
        node = node.getNextSibling();
        i++;
      }
      if (i < index) {
        throw new IllegalArgumentException(Integer.toString(index));
      }
    }
    if (node == null) {
      parent.appendChild(child);
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
   * @return a new {@link HTMLFormElement}.
   */
  protected static HTMLFormElement newForm() {

    return DOC.createElement("form").cast();
  }

  /**
   * @return a new {@link HTMLVideoElement}.
   */
  protected static HTMLVideoElement newVideo() {

    return DOC.createElement("video").cast();
  }

  /**
   * @return a new {@link HTMLAudioElement}.
   */
  protected static HTMLAudioElement newAudio() {

    return DOC.createElement("audio").cast();
  }

  /**
   * @return a new {@link HTMLElement fieldset element}.
   */
  protected static HTMLElement newFieldSet() {

    return DOC.createElement("fieldset").cast();
  }

  /**
   * @return a new {@link HTMLElement legend element}.
   */
  protected static HTMLElement newLegend() {

    return DOC.createElement("legend").cast();
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

  /**
   * @param name the {@link HTMLElement#getClassName() CSS class name} of the icon.
   * @return a new {@link HTMLElement}.
   */
  protected static HTMLElement newIcon(String name) {

    HTMLElement input = newElement(TAG_NAME_UI_ICON);
    input.setClassName(name);
    return input;
  }

}
