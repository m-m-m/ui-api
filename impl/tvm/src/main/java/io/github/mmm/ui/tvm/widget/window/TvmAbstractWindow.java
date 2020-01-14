/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.window;

import org.teavm.jso.JSObject;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.TvmWidgetJsObject;
import io.github.mmm.ui.widget.window.UiAbstractWindow;

/**
 * Implementation of {@link UiAbstractWindow} for TeaVM.
 *
 * @param <W> type of {@link #getWidget() TeaVM widget}.
 * @since 1.0.0
 */
public abstract class TvmAbstractWindow<W extends JSObject> extends TvmWidgetJsObject<W> implements UiAbstractWindow {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public TvmAbstractWindow(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

}
