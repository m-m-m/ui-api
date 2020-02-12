/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.panel;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiEnabledFlags;
import io.github.mmm.ui.tvm.widget.composite.TvmDynamicComposite;
import io.github.mmm.ui.widget.input.UiAbstractInput;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;

/**
 * Implementation of {@link UiVerticalPanel} using TeaVM.
 *
 * @since 1.0.0
 */
public class TvmFormPanel extends TvmDynamicComposite<HTMLElement, UiAbstractInput<?>> implements UiFormPanel {

  private String validationFailure;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmFormPanel(UiContext context) {

    super(context, Window.current().getDocument().createElement("ui-vpanel"));
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public TvmFormPanel(UiContext context, HTMLElement widget) {

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

  @Override
  protected void setEnabledNative(boolean enabled) {

    for (UiAbstractInput<?> child : this.children) {
      child.setEnabled(enabled, UiEnabledFlags.PARENT);
    }
  }

}
