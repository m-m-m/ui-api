/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.button.UiAbstractButton;
import io.github.mmm.ui.widget.panel.UiButtonPanel;

/**
 * Implementation of {@link UiButtonPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmButtonPanel extends TvmDynamicComposite<HTMLElement, UiAbstractButton> implements UiButtonPanel {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmButtonPanel(UiContext context) {

    super(context, Window.current().getDocument().createElement("ui-buttons"));
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmButtonPanel(UiContext context, HTMLElement widget) {

    super(context, widget);
  }

}
