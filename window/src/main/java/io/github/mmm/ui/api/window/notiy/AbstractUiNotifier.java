/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.window.notiy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.notify.UiNotification;
import io.github.mmm.ui.api.notify.UiSeverity;
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
 * Abstract base implementation of {@link UiPopupNotifier}.
 */
public abstract class AbstractUiNotifier implements UiPopupNotifier {

  private final List<UiNotification> notifications;

  private final Iterable<UiNotification> history;

  private Predicate<UiNotification> popupFilter = x -> false;

  /**
   * The constructor.
   */
  public AbstractUiNotifier() {

    super();
    this.notifications = new ArrayList<>();
    this.history = Collections.unmodifiableList(this.notifications);
  }

  @Override
  public Iterable<UiNotification> getHistory() {

    return this.history;
  }

  /**
   * @param notification the {@link UiNotification} to add to the {@link #getHistory() notifications}.
   */
  private void add(UiNotification notification) {

    this.notifications.add(notification);
  }

  @Override
  public void event(String message, String title) {

    add(UiNotification.of(message, UiSeverity.EVENT, title));
  }

  @Override
  public void show(UiNotification notification) {

    if (this.popupFilter.test(notification)) {
      showPopupOk(notification);
    } else {
      add(notification);
      showGrowl(notification);
    }
  }

  /**
   * @param notification the {@link UiNotification} to show as growl message box. Such growl box will typically appear
   *        at the bottom right and automatically fade out after some time.
   */
  public abstract void showGrowl(UiNotification notification);

  @Override
  public UiPopup createPopup(UiNotification notification, UiAction... actions) {

    add(notification);
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
