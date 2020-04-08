/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.UiNotifier;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiText;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.img.UiIcon;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.panel.UiCollapsiblePanel;
import io.github.mmm.ui.api.widget.panel.UiHorizontalPanel;
import io.github.mmm.ui.api.widget.panel.UiScrollPanel;
import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.api.widget.window.UiPopup;

/**
 * Abstract base implementation of {@link UiNotifier}.
 */
public abstract class AbstractUiNotifier implements UiNotifier {

  private final UiContext context;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public AbstractUiNotifier(UiContext context) {

    super();
    this.context = context;
  }

  /**
   * @return the {@link UiContext}.
   */
  public UiContext getContext() {

    return this.context;
  }

  @Override
  public UiPopup showPopup(String message, UiSeverity severity, String title, String details, UiAction... actions) {

    UiPopup popup = this.context.create(UiPopup.class);
    if ((title == null) || title.isEmpty()) {
      title = this.context.localize(severity.getName());
    }
    if (title == null) {
      title = severity.getName();
    }
    popup.setTitle(title);
    UiText text = UiText.of(this.context, message);
    UiRegularWidget child = text;
    if (severity != null) {
      UiIcon icon = UiIcon.of(this.context, severity.getName());
      icon.setSize(3);
      child = UiHorizontalPanel.of(this.context, icon, text);
    }
    if ((details != null) && !details.isEmpty()) {
      UiScrollPanel scrollPanel = UiScrollPanel.of(this.context, UiText.of(this.context, details));
      UiCollapsiblePanel detailsPanel = UiCollapsiblePanel.of(this.context, scrollPanel);
      child = UiVerticalPanel.of(this.context, child, detailsPanel);
    }
    popup.addChild(child);
    UiButtonPanel buttonPanel = popup.getButtonPanel();
    for (UiAction action : actions) {
      UiButton button = UiButton.of(this.context, action);
      UiClickEventListener closeListener = e -> popup.close();
      button.addListener(closeListener);
      buttonPanel.addChild(button);
    }
    popup.setVisible(true);
    return popup;
  }

}