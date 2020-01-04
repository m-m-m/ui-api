/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.widget;

import io.github.mmm.event.AbstractEventSource;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * Abstract base implementation of {@link UiWidget}.
 */
public abstract class AbstractUiWidget extends AbstractEventSource<UiEvent, UiEventListener> implements UiWidget {

  /** @see #getContext() */
  protected final UiContext context;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public AbstractUiWidget(UiContext context) {

    super();
    this.context = context;
  }

  @Override
  public UiContext getContext() {

    return this.context;
  }

  /**
   * @param parent the new {@link #getParent() parent}.
   */
  protected abstract void setParent(UiComposite<?> parent);

  /**
   * @param widget the {@link UiWidget}.
   * @param parent the new {@link #getParent() parent}.
   * @see #setParent(UiComposite)
   */
  protected static void setParent(UiWidget widget, UiComposite<?> parent) {

    ((AbstractUiWidget) widget).setParent(parent);
  }

}
