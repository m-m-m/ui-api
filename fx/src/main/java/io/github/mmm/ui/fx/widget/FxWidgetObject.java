/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.widget.AbstractUiNativeWidgetWrapper;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.custom.UiCustomWidget;
import javafx.css.PseudoClass;
import javafx.scene.Node;

/**
 * Implementation of {@link io.github.mmm.ui.widget.UiNativeWidget} for JavaFx.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetObject<W> extends AbstractUiNativeWidgetWrapper<W> {

  /**
   * {@link PseudoClass} if JavaFx widget gets
   * {@link io.github.mmm.ui.fx.widget.input.FxInput#setValidationFailure(String) invalid}.
   */
  public static final PseudoClass CLASS_INVALID = PseudoClass.getPseudoClass("invalid");

  /**
   * {@link PseudoClass} if JavaFx widget gets {@link io.github.mmm.ui.fx.widget.input.FxInput#setReadOnly(boolean)
   * read-only}.
   */
  public static final PseudoClass CLASS_READ_ONLY = PseudoClass.getPseudoClass("read-only");

  /** @see #getNativeWidget() */
  protected final W nativeWidget;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxWidgetObject(UiContext context, W nativeWidget) {

    super(context);
    this.nativeWidget = nativeWidget;
  }

  @Override
  public W getNativeWidget() {

    return this.nativeWidget;
  }

  /**
   * @param widget the {@link UiWidget}.
   * @return the {@link #getNativeWidget() containing} JavaFx {@link Node}.
   */
  protected Node getNode(UiWidget widget) {

    if (widget instanceof UiCustomWidget) {
      getNode(((UiCustomWidget<?>) widget).getDelegate());
    }
    return ((FxWidgetNode<?>) widget).getNativeWidget();
  }

  @Override
  protected boolean isReadOnlyNative() {

    return true;
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

}