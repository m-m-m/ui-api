/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.notifier;

import io.github.mmm.ui.api.datatype.UiNotification;
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

  /**
   * The constructor.
   */
  public AbstractUiNotifier() {

    super();
  }

  @Override
  public UiPopup createPopup(UiNotification notification, UiAction... actions) {

    UiPopup popup = UiPopup.of(notification.getTitle());
    UiText text = UiText.of(notification.getMessage());
    UiRegularWidget child = text;
    UiSeverity severity = notification.getSeverity();
    if (severity != null) {
      UiIcon icon = UiIcon.of(severity.getName());
      icon.setSize(3);
      child = UiHorizontalPanel.of(icon, text);
    }
    String details = notification.getDetails();
    if ((details != null) && !details.isEmpty()) {
      UiScrollPanel scrollPanel = UiScrollPanel.of(UiText.of(details));
      UiCollapsiblePanel detailsPanel = UiCollapsiblePanel.of(scrollPanel);
      child = UiVerticalPanel.of(child, detailsPanel);
    }
    popup.addChild(child);
    UiButtonPanel buttonPanel = popup.getButtonPanel();
    for (UiAction action : actions) {
      UiButton button = UiButton.of(action);
      UiClickEventListener closeListener = e -> popup.close();
      button.addListener(closeListener);
      buttonPanel.addChild(button);
    }
    popup.getSize().setWidthInPixel(400);
    popup.getSize().setHeightInPixel(100);
    return popup;
  }

}
