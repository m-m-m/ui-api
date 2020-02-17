/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.panel.UiHorizontalPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;

/**
 * Implementation of {@link UiVerticalPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmHorizontalPanel extends TvmDynamicPanel<HTMLElement> implements UiHorizontalPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmHorizontalPanel(UiContext context) {

    super(context, Window.current().getDocument().createElement("ui-hpanel"));
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmHorizontalPanel(UiContext context, HTMLElement widget) {

    super(context, widget);
  }

}
