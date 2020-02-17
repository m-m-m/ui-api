/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.panel.UiDynamicPanel;

/**
 * Implementation of {@link UiDynamicPanel} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public class TvmDynamicPanel<W extends HTMLElement> extends TvmDynamicComposite<W, UiRegularWidget>
    implements UiDynamicPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmDynamicPanel(UiContext context, W widget) {

    super(context, widget);
  }

}
