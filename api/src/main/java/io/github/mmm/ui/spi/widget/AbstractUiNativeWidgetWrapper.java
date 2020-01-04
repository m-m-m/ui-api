/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiStyles;
import io.github.mmm.ui.spi.UiStylesImpl;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * Abstract base implementation of {@link UiNativeWidget} implementing {@link #getStyles()}.
 *
 * @param <W> type of the {@link #getNativeWidget() widget}.
 * @since 1.0.0
 */
public abstract class AbstractUiNativeWidgetWrapper<W> extends AbstractUiNativeWidget
    implements UiNativeWidgetWrapper<W> {

  private UiStyles styles;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public AbstractUiNativeWidgetWrapper(UiContext context) {

    super(context);
  }

  @Override
  public UiStyles getStyles() {

    if (this.styles == null) {
      this.styles = createStyles();
    }
    return this.styles;
  }

  /**
   * @return the {@link UiStyles} implementation used by {@link #getStyles()}.
   */
  protected UiStyles createStyles() {

    return new Styles();
  }

  /**
   * @param newStyles the new styles.
   */
  protected void onStylesChanged(String newStyles) {

    // nothing by default
  }

  private class Styles extends UiStylesImpl {

    @Override
    protected void onStylesChanged() {

      AbstractUiNativeWidgetWrapper.this.onStylesChanged(get());
    }
  }
}
