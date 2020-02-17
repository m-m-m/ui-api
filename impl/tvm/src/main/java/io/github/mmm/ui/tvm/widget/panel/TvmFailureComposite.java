/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.attribute.UiWidgetWithValidationFailure;
import io.github.mmm.ui.widget.composite.UiFailureComposite;

/**
 * {@link TvmDynamicComposite} with {@link UiWidgetWithValidationFailure validation failure}.
 *
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class TvmFailureComposite<C extends UiWidget> extends TvmDynamicComposite<HTMLElement, C>
    implements UiFailureComposite<C> {

  private String validationFailure;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() TeaVM widget}.
   */
  public TvmFailureComposite(UiContext context, HTMLElement widget) {

    super(context, widget);
  }

  @Override
  public String getValidationFailure() {

    return this.validationFailure;
  }

  @Override
  public void setValidationFailure(String validationFailure) {

    boolean invalid = !isEmpty(validationFailure);
    if (invalid) {
      this.validationFailure = validationFailure;
      getStyles().add(STYLE_INVALID);
    } else {
      this.validationFailure = null;
      getStyles().remove(STYLE_INVALID);
    }
    // TODO apply validationFailure to widget!
  }

}
