/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.notifier;

import java.util.function.Consumer;

import io.github.mmm.ui.api.datatype.UiNotification;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.event.action.UiActionNo;
import io.github.mmm.ui.api.event.action.UiActionOk;
import io.github.mmm.ui.api.event.action.UiActionYes;
import io.github.mmm.ui.api.widget.window.UiPopup;
import io.github.mmm.ui.impl.notifier.UiNotifierProvider;

/**
 * Interface to notify via popup or growl.
 *
 * @since 1.0.0
 */
public interface UiNotifier {

  /**
   * This method shows a {@link UiNotification} to the end-user. Typically it will show a growl box appearing at the
   * bottom right that fades out automatically after a while so the end-user is not disturbed. However, it is possible
   * to configure that {@link UiNotification}s of a higher {@link UiNotification#getSeverity() severity} (e.g.
   * {@link UiSeverity#ERROR}) will be {@link #showPopupOk(UiNotification) shown as popup}.
   *
   * @param notification the {@link UiNotification} to show.
   */
  void show(UiNotification notification);

  /**
   * Shows an error to the end-user
   *
   * @param error the {@link Throwable} that has been catched.
   * @see #show(UiNotification)
   */
  default void show(Throwable error) {

    show(UiNotification.of(error));
  }

  /**
   * @param message the {@link UiNotification#getMessage() message} to show.
   * @see #show(UiNotification)
   */
  default void showInfo(String message) {

    show(UiNotification.ofInfo(message));
  }

  /**
   * This method creates a {@link UiPopup popup window} with the given {@code message}. It is the most generic and
   * flexible but also the most inconvenient {@code showPopup} method variant.
   *
   * @param notification the {@link UiNotification} to show.
   * @param actions are the {@link UiAction}s for the buttons to close (answer, confirm, or cancel) the popup. Has to be
   *        at least one {@link UiAction}.
   * @return the {@link UiPopup}.
   */
  UiPopup createPopup(UiNotification notification, UiAction... actions);

  /**
   * This method creates a {@link UiPopup popup window} with the given {@link UiNotification} and two buttons for the
   * options {@link UiActionYes yes} and {@link UiActionNo no}. <br>
   * <b>ATTENTION:</b><br>
   * This is a very convenient but also very often misused feature of UI toolkits or frameworks. A suitable example is
   * e.g. to use this with the message "Do you really want to delete this object?". However, it would still be more
   * explicit to have the buttons labeled with "Delete" and "Cancel" using
   * {@link #createPopup(UiNotification, UiAction...)}. A famous example for a misuse of this method would be the
   * question "Do you want to delete this occurrence or the series of the appointment? Press 'Yes' to delete the series
   * and 'No' for this occurrence.". From this bad example that confuses the user, you should learn that it is always
   * better to use more explicit button labels.
   *
   * @param notification the {@link UiNotification} to show. Should have {@link UiSeverity#QUESTION}.
   * @param callback is the {@link Consumer} invoked after the popup has been confirmed. {@link Consumer#accept(Object)}
   *        will receive {@link Boolean#TRUE} if the user clicked "Yes" and {@link Boolean#FALSE} for "No".
   * @return the {@link UiPopup}.
   */
  default UiPopup createPopupYesNo(UiNotification notification, Consumer<Boolean> callback) {

    UiActionYes yes = (e) -> {
      callback.accept(Boolean.TRUE);
    };
    UiActionNo no = (e) -> {
      callback.accept(Boolean.FALSE);
    };
    return createPopup(notification, yes, no);
  }

  /**
   * This method shows a {@link UiNotification} to the end-user in a modal popup window.<br>
   * <b>ATTENTION</b>: It is recommended to use {@link #show(UiNotification)} instead and to avoid modal popups or
   * allowing to configure which notifications should be shown as popup instead of hardcoding it.
   *
   * @param notification the {@link UiNotification} to show.
   * @param actions are the {@link UiAction}s for the buttons to close (answer, confirm, or cancel) the popup. Has to be
   *        at least one {@link UiAction}.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopup(UiNotification notification, UiAction... actions) {

    UiPopup popup = createPopup(notification, actions);
    popup.open();
    return popup;
  }

  /**
   * This method shows a {@link UiNotification} to the end-user in a modal popup window.<br>
   * <b>ATTENTION</b>: It is recommended to use {@link #show(UiNotification)} instead and to avoid modal popups or
   * allowing to configure which notifications should be shown as popup instead of hardcoding it.
   *
   * @param notification the {@link UiNotification} to show.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(UiNotification notification) {

    return showPopup(notification, UiActionOk.NONE);
  }

  /**
   * This method shows a {@link UiNotification} to the end-user in a modal popup window.<br>
   * <b>ATTENTION</b>: It is recommended to use {@link #show(UiNotification)} instead and to avoid modal popups or
   * allowing to configure which notifications should be shown as popup instead of hardcoding it.
   *
   * @param notification the {@link UiNotification} to show.
   * @param action is the optional {@link UiActionOk}.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(UiNotification notification, UiActionOk action) {

    return showPopup(notification, UiActionOk.notNull(action));
  }

  /**
   * This method shows a {@link UiPopup popup window} with the given {@link UiNotification} and two buttons for the
   * options {@link UiActionYes yes} and {@link UiActionNo no}. <br>
   * <b>ATTENTION:</b><br>
   * This is a very convenient but also very often misused feature of UI toolkits or frameworks. A suitable example is
   * e.g. to use this with the message "Do you really want to delete this object?". However, it would still be more
   * explicit to have the buttons labeled with "Delete" and "Cancel" using
   * {@link #createPopup(UiNotification, UiAction...)}. A famous example for a misuse of this method would be the
   * question "Do you want to delete this occurrence or the series of the appointment? Press 'Yes' to delete the series
   * and 'No' for this occurrence.". From this bad example that confuses the user, you should learn that it is always
   * better to use more explicit button labels.
   *
   * @param notification the {@link UiNotification} to show. Should have {@link UiSeverity#QUESTION}.
   * @param callback is the {@link Consumer} invoked after the popup has been confirmed. {@link Consumer#accept(Object)}
   *        will receive {@link Boolean#TRUE} if the user clicked "Yes" and {@link Boolean#FALSE} for "No".
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupYesNo(UiNotification notification, Consumer<Boolean> callback) {

    UiPopup popup = createPopupYesNo(notification, callback);
    popup.open();
    return popup;
  }

  /**
   * @param message the {@link UiNotification#getMessage() message}.
   * @param title the {@link UiNotification#getTitle() title}.
   */
  void event(String message, String title);

  /**
   * @return the history of the notifications collected by this {@link UiNotifier}. It may be only a queue with the last
   *         N number of {@link UiNotification}s to avoid memory leaks.
   */
  Iterable<UiNotification> getHistory();

  /**
   * @return the singleton instance of this {@link UiNotifier}.
   */
  static UiNotifier get() {

    return UiNotifierProvider.NOTIFIER;
  }

}
