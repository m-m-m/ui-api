/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.function.Consumer;

import io.github.mmm.ui.datatype.UiSeverity;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.event.action.UiActionNo;
import io.github.mmm.ui.event.action.UiActionOk;
import io.github.mmm.ui.event.action.UiActionYes;
import io.github.mmm.ui.widget.window.UiPopup;

/**
 * Interface to notify via popup or growl.
 *
 * @since 1.0.0
 */
public interface UiNotifier {

  /**
   * This method opens a notification (growl) information message. This will typically appear at the bottom right and
   * fade out automatically after a delay.
   *
   * @see #showNotification(String, UiSeverity)
   *
   * @param message is the message to display.
   */
  default void showNotification(String message) {

    showNotification(message, UiSeverity.INFORMATION);
  }

  /**
   * This method opens a notification (growl) message. This will typically appear at the bottom right and fade out
   * automatically after a delay.
   *
   * @see #showPopupOk(String, UiSeverity, String)
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   */
  void showNotification(String message, UiSeverity severity);

  /**
   * This method opens a confirmation popup window with the given {@code message}. The title of the popup is
   * automatically derived from the given {@link UiSeverity}.
   *
   * @see #showPopupOk(String, UiSeverity, String)
   *
   * @param message is the message to display.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(String message) {

    return showPopupOk(message, UiSeverity.INFORMATION);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message}. The title of the popup is
   * automatically derived from the given {@link UiSeverity}.
   *
   * @see #showPopupOk(String, UiSeverity, String)
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(String message, UiSeverity severity) {

    return showPopupOk(message, severity, null, null);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message} and an .
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   * @param title is the title that will be displayed in the title-bar of the popup.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(String message, UiSeverity severity, String title) {

    return showPopupOk(message, severity, title, null);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message} and an "OK" button.
   *
   * @param message is the message to display.
   * @param title is the title that will be displayed in the title-bar of the popup.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   * @param action is the {@link UiActionOk}.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(String message, UiSeverity severity, String title, UiActionOk action) {

    return showPopup(message, severity, title, null, UiActionOk.notNull(action));
  }

  /**
   * This method opens a confirmation popup window showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(Throwable error) {

    String message = error.getLocalizedMessage();
    if (message == null) {
      message = error.getClass().getSimpleName();
    }
    return showPopupOk(error, message, null);
  }

  /**
   * This method opens a confirmation popup dialog showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   * @param message is the message to display.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(Throwable error, String message) {

    return showPopupOk(error, message, null);
  }

  /**
   * This method opens a confirmation popup dialog showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   * @param message is the message to display.
   * @param action is the {@link UiActionOk}.
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupOk(Throwable error, String message, UiActionOk action) {

    StringWriter sw = new StringWriter(256);
    error.printStackTrace(new PrintWriter(sw));
    String details = sw.toString();
    return showPopup(message, UiSeverity.ERROR, null, details, UiActionOk.notNull(action));
  }

  /**
   * This method opens a {@link UiSeverity#QUESTION question} popup window with the given {@code message} and two
   * buttons for the options {@link UiActionYes yes} and {@link UiActionNo no}. <br>
   * <b>ATTENTION:</b><br>
   * This is a very common also also very often misused feature of UI toolkits or frameworks. A suitable example is e.g.
   * to use this with the message "Do you really want to delete this object?". However, it would still be more explicit
   * to have the buttons labeled with "Delete" and "Cancel" using
   * {@link #showPopup(String, UiSeverity, String, String, UiAction...)}. An example for a misuse of this method would
   * be the message "Do you want to delete this occurrence or the series of the appointment? Press 'Yes' to delete the
   * series and 'No' for this occurrence.". From this bad example that confuses the user, you should learn that it is
   * always better to use more explicit button labels.
   *
   * @param message is the message to display.
   * @param title is the title that will be displayed in the title-bar of the popup. May be {@code null} to use the
   *        default title for {@link UiSeverity#QUESTION}.
   * @param callback is the {@link Consumer} invoked after the popup has been confirmed. {@link Consumer#accept(Object)}
   *        will receive {@link Boolean#TRUE} if the user clicked "Yes" and {@link Boolean#FALSE} for "No".
   * @return the {@link UiPopup}.
   */
  default UiPopup showPopupYesNo(String message, String title, Consumer<Boolean> callback) {

    UiActionYes yes = (e) -> {
      callback.accept(Boolean.TRUE);
    };
    UiActionNo no = (e) -> {
      callback.accept(Boolean.FALSE);
    };
    return showPopup(message, UiSeverity.QUESTION, title, null, yes, no);
  }

  /**
   * This method opens a popup window with the given {@code message}. It is the most generic and flexible but also the
   * most inconvenient {@code showPopup} method variant.
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}.
   * @param title is the title that will be displayed in the title-bar of the popup. May be {@code null} to use the
   *        default title for the given {@link UiSeverity}.
   * @param callback is the {@link Consumer} invoked after the popup has been confirmed (the user has clicked on one of
   *        the buttons). The {@link String} value received by {@link Consumer#accept(Object)} will be the ID of the
   *        button that has been clicked what is the {@link Map#keySet() key} of the given {@code id2buttonLabelMap}.
   * @param details the optional details. If not {@code null} details will be shown but are initially collapsed and have
   *        to be expanded by the end user.
   * @param actions are the {@link UiAction}s for the buttons to close (answer, confirm, or cancel) the popup. Has to be
   *        at least one {@link UiAction}.
   * @return the {@link UiPopup}.
   */
  UiPopup showPopup(String message, UiSeverity severity, String title, String details, UiAction... actions);

}
