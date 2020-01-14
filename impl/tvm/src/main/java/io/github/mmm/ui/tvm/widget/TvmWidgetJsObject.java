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
   * @param widget the {@link #getWidget() JavaFx widget}.
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
   * @param uiWidget the {@link UiWidget}.
   * @return the {@link #getWidget() containing} JavaFx {@link Node}.
   */
  protected static Node getTopNode(UiWidget uiWidget) {

    if (uiWidget instanceof UiCustomWidget) {
      getTopNode(((UiCustomWidget<?>) uiWidget).getDelegate());
    }
    return ((TvmWidgetHtmlElement<?>) uiWidget).getTopWidget();
  }

}
