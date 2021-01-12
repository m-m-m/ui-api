/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.window.notiy;

import java.util.function.Consumer;

import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.event.action.UiActionNo;
import io.github.mmm.ui.api.event.action.UiActionOk;
import io.github.mmm.ui.api.event.action.UiActionYes;
import io.github.mmm.ui.api.notify.UiNotification;
import io.github.mmm.ui.api.notify.UiNotifier;
import io.github.mmm.ui.api.notify.UiSeverity;
import io.github.mmm.ui.api.widget.window.UiPopup;

/**
 * Interface to notify via popup or growl.
 *
 * @since 1.0.0
 */
public interface UiPopupNotifier extends UiNotifier {

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
   * This method creates a {@link UiPopup popup window} with the given {@code message}. It is the most generic and
   * flexible but also the most inconvenient {@code showPopup} method variant.
   *
   * @param notification the {@link UiNotification} to show.
   * @param actions are the {@link UiAction}s for the buttons to close (answer, confirm, or cancel) the popup. Has to be
   *        at least one {@link UiAction}.
   * @return the {@link UiPopup}.
   */
  default UiPopup createPopupOk(UiNotification notification) {

    return createPopup(notification, UiActionOk.NONE);
  }

  /**
   * This method creates a {@link UiPopup popup window} with the given {@code message}. It is the most generic and
   * flexible but also the most inconvenient {@code showPopup} method variant.
   *
   * @param notification the {@link UiNotification} to show.
   * @param action the optional {@link UiActionOk} to invoke when OK is pressed and the popup is closed.
   * @return the {@link UiPopup}.
   */
  default UiPopup createPopupOk(UiNotification notification, UiActionOk action) {

    return createPopup(notification, UiActionOk.notNull(action));
  }

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

  @Override
  default void showPopup(UiNotification notification, UiAction... actions) {

    UiPopup popup = createPopup(notification, actions);
    popup.open();
  }

  @Override
  default void showPopupOk(UiNotification notification) {

    UiPopup popup = createPopupOk(notification);
    popup.open();
  }

  @Override
  default void showPopupOk(UiNotification notification, UiActionOk action) {

    UiPopup popup = createPopupOk(notification, action);
    popup.open();
  }

  @Override
  default void showPopupYesNo(UiNotification notification, Consumer<Boolean> callback) {

    UiPopup popup = createPopupYesNo(notification, callback);
    popup.open();
  }

  /**
   * @return the history of the notifications collected by this {@link UiNotifier}. It may be only a queue with the last
   *         N number of {@link UiNotification}s to avoid memory leaks.
   */
  @Override
  Iterable<UiNotification> getHistory();

  /**
   * @return the singleton instance of this {@link UiNotifier}.
   */
  static UiPopupNotifier get() {

    return (UiPopupNotifier) UiNotifier.get();
  }

}
