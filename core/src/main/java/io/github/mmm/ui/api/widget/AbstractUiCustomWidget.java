/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.ui.api.datatype.UiStyles;
import io.github.mmm.ui.api.datatype.UiValidState;
import io.github.mmm.ui.api.datatype.bitmask.BitMask;
import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.widget.composite.UiComposite;

/**
 * This is the abstract base implementation of {@link UiCustomWidget}.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiCustomWidget<W extends UiWidget> extends AbstractUiWidget implements UiCustomWidget<W> {

  /** @see #getDelegate() */
  protected final W delegate;

  /** @see #initialize() */
  private boolean initialized;

  /**
   * The constructor.
   *
   * @param delegate is the {@link #getDelegate() delegate}.
   */
  public AbstractUiCustomWidget(W delegate) {

    super();
    this.delegate = delegate;
  }

  @Override
  public final W getDelegate() {

    return this.delegate;
  }

  /**
   * This method gets the {@link #getDelegate() delegate} of the given widget.
   *
   * @param <T> type of the {@link #getDelegate() delegate} of the given widgets.
   *
   * @param customWidget is the widget for which the {@link #getDelegate() delegate} is requested.
   * @return the requested {@link #getDelegate() delegate}.
   */
  protected static final <T extends UiWidget> T getDelegate(AbstractUiCustomWidget<T> customWidget) {

    return customWidget.getDelegate();
  }

  @Override
  protected UiNativeWidget unwrap() {

    return unwrap(this.delegate);
  }

  /**
   * This method initializes this widget. It is automatically called from {@link #setParent(UiComposite)} so
   * initialization is performed before the widget is actually attached to the screen for the first time. The first call
   * of this method delegates to {@link #doInitialize()}. Further calls of this method will have no effect. <br>
   * <b>ATTENTION:</b><br>
   * You should not call this method directly unless you are absolutely aware of what you are doing.
   */
  protected final void initialize() {

    if (!this.initialized) {
      doInitialize();
      this.initialized = true;
    }
  }

  /**
   * This method is called from {@link #initialize()} but only if called for the first time. You may override this
   * method to add additional initialization logic. Then do not forget the <code>super</code> call. <br>
   * <b>ATTENTION:</b><br>
   * Never call this method directly.
   */
  protected void doInitialize() {

    // nothing by default...
  }

  // --- delegation methods ---

  @Override
  public void addListener(UiEventListener listener, boolean weak) {

    this.delegate.addListener(listener, weak);
  }

  @Override
  public boolean removeListener(UiEventListener listener) {

    return this.delegate.removeListener(listener);
  }

  @Override
  public final UiComposite<?> getParent() {

    return this.delegate.getParent();
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    setParent(this.delegate, parent);
  }

  @Override
  public final void dispose() {

    this.delegate.dispose();
  }

  @Override
  public final boolean isDisposed() {

    return this.delegate.isDisposed();
  }

  @Override
  public boolean isVisible(BitMask flagMode) {

    return this.delegate.isVisible(flagMode);
  }

  @Override
  public void setVisible(boolean visible, BitMask flagMode) {

    this.delegate.setVisible(visible, flagMode);
  }

  @Override
  public boolean isEnabled(BitMask flagMode) {

    return this.delegate.isEnabled(flagMode);
  }

  @Override
  public void setEnabled(boolean enabled, BitMask flagMode) {

    this.delegate.setEnabled(enabled, flagMode);
  }

  @Override
  public UiStyles getStyles() {

    return this.delegate.getStyles();
  }

  @Override
  public final String getId() {

    return this.delegate.getId();
  }

  @Override
  public final void setId(String id) {

    this.delegate.setId(id);
  }

  @Override
  public boolean isReadOnly() {

    return this.delegate.isReadOnly();
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    this.delegate.setReadOnly(readOnly);
  }

  @Override
  public Boolean getReadOnlyFixed() {

    return this.delegate.getReadOnlyFixed();
  }

  @Override
  public void setReadOnlyFixed(Boolean readOnlyFixed) {

    this.delegate.setReadOnlyFixed(readOnlyFixed);
  }

  @Override
  public boolean validateDown(UiValidState state) {

    return this.delegate.validateDown(state);
  }

  @Override
  public String getTooltip() {

    return this.delegate.getTooltip();
  }

  @Override
  public void setTooltip(String tooltip) {

    this.delegate.setTooltip(tooltip);
  }

}
