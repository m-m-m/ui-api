/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import io.github.mmm.ui.datatype.UiSeverity;
import io.github.mmm.ui.datatype.UiValidState;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.event.action.UiActionNo;
import io.github.mmm.ui.event.action.UiActionOk;
import io.github.mmm.ui.event.action.UiActionYes;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.ui.widget.window.UiMainWindow;
import io.github.mmm.value.ReadableTypedValue;

/**
 * Context and central API of the user-interface (UI). UIs consist of many smaller components that should be easy to
 * create. Dependency injection (DI) would make the programming model more complex. In such cases you need to pass
 * required components manually. This context is the central container to make this easy and maintainable. It acts as
 * factory for other {@link UiWidget}s as well as contextual state for the UI.
 *
 * @since 1.0.0
 */
public interface UiContext {

  /**
   * @return the {@link UiMainWindow} running this application. It will hold the {@link UiMainWindow#getMenuBar() menu
   *         bar} and should be the main entry point to your application for end-users.
   */
  UiMainWindow getMainWindow();

  /**
   * @return the {@link Locale} of the current user.
   */
  Locale getLocale();

  /**
   * @return the {@link UiScreen} to read the current screen resolution.
   */
  UiScreen getScreen();

  /**
   * @return the {@link UiDispatcher}.
   */
  UiDispatcher getDispatcher();

  /**
   * @return a new {@link UiToggleGroup} instance.
   */
  UiToggleGroup createToggleGroup();

  /**
   * This method opens a confirmation popup window with the given {@code message}. The title of the popup is
   * automatically derived from the given {@link UiSeverity}.
   *
   * @see #showPopupOk(String, UiSeverity, String)
   *
   * @param message is the message to display.
   */
  default void showPopupOk(String message) {

    showPopupOk(message, UiSeverity.INFORMATION);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message}. The title of the popup is
   * automatically derived from the given {@link UiSeverity}.
   *
   * @see #showPopupOk(String, UiSeverity, String)
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   */
  default void showPopupOk(String message, UiSeverity severity) {

    showPopupOk(message, severity, null, null);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message} and an .
   *
   * @param message is the message to display.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   * @param title is the title that will be displayed in the title-bar of the popup.
   */
  default void showPopupOk(String message, UiSeverity severity, String title) {

    showPopupOk(message, severity, title, null);
  }

  /**
   * This method opens a confirmation popup window with the given {@code message} and an "OK" button.
   *
   * @param message is the message to display.
   * @param title is the title that will be displayed in the title-bar of the popup.
   * @param severity is the {@link UiSeverity}. Should NOT be {@link UiSeverity#QUESTION}.
   * @param action is the {@link UiActionOk}.
   */
  default void showPopupOk(String message, UiSeverity severity, String title, UiActionOk action) {

    showPopup(message, severity, title, null, UiActionOk.notNull(action));
  }

  /**
   * This method opens a confirmation popup window showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   */
  default void showPopupOk(Throwable error) {

    String message = error.getLocalizedMessage();
    if (message == null) {
      message = error.getClass().getSimpleName();
    }
    showPopupOk(error, message, null);
  }

  /**
   * This method opens a confirmation popup dialog showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   * @param message is the message to display.
   */
  default void showPopupOk(Throwable error, String message) {

    showPopupOk(error, message, null);
  }

  /**
   * This method opens a confirmation popup dialog showing the given {@code error}. It will use
   * {@link UiSeverity#ERROR}.
   *
   * @param error is the {@link Throwable} that has occurred.
   * @param message is the message to display.
   * @param action is the {@link UiActionOk}.
   */
  default void showPopupOk(Throwable error, String message, UiActionOk action) {

    StringWriter sw = new StringWriter(256);
    error.printStackTrace(new PrintWriter(sw));
    String details = sw.toString();
    showPopup(message, UiSeverity.ERROR, null, details, UiActionOk.notNull(action));
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
   */
  default void showPopupYesNo(String message, String title, Consumer<Boolean> callback) {

    UiActionYes yes = (e) -> {
      callback.accept(Boolean.TRUE);
    };
    UiActionNo no = (e) -> {
      callback.accept(Boolean.FALSE);
    };
    showPopup(message, UiSeverity.QUESTION, title, null, yes, no);
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
   */
  void showPopup(String message, UiSeverity severity, String title, String details, UiAction... actions);

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @return the new {@link UiNativeWidget}.
   */
  default <W extends UiNativeWidget> W create(Class<W> widgetInterface) {

    return create(widgetInterface, true);
  }

  /**
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @param required {@code true} if a {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryNative} has to be registered
   *        for the given {@code widgetInterface}, {@code false} otherwise.
   * @return the new {@link UiNativeWidget}. May be {@code null} if {@code required} is {@code false}.
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required);

  /**
   * @param <V> type of the {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype the {@link Class} reflecting the
   *        {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @return the {@link UiInput} for the given {@code datatype}.
   */
  default <V> UiInput<V> createInput(Class<V> datatype) {

    return createInput(datatype, true);
  }

  /**
   * @param <V> type of the {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param datatype the {@link Class} reflecting the
   *        {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype#getType() datatype}.
   * @param required {@code true} if a {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype} has to be
   *        registered for the given {@code datatype}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code datatype}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  <V> UiInput<V> createInput(Class<V> datatype, boolean required);

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @return the {@link UiInput} for the given {@code property}.
   */
  default <V> UiInput<V> createInput(ReadableTypedValue<V> property) {

    return createInput(property, true);
  }

  /**
   * @param <V> type of the {@link ReadableTypedValue property}.
   * @param property the {@link Class} reflecting the {@link ReadableTypedValue property}.
   * @param required {@code true} if a {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryProperty} or
   *        {@link io.github.mmm.ui.factory.UiSingleWidgetFactoryDatatype} has to be registered for the given
   *        {@code property}, {@code false} otherwise.
   * @return the {@link UiInput} for the given {@code property}. May be {@code null} if {@code required} is
   *         {@code false}.
   */
  <V> UiInput<V> createInput(ReadableTypedValue<V> property, boolean required);

  /**
   * Creates a new {@link UiButton} for the given {@link UiAction}.
   *
   * @param action the {@link UiAction}.
   * @return the new widget instance.
   */
  UiButton createButton(UiAction action);

  /**
   * @return the default {@link io.github.mmm.ui.widget.attribute.UiWidgetWithValidationFailure#getValidationFailure()
   *         validation failure} message to show if something is invalid (e.g. for
   *         {@link io.github.mmm.ui.widget.composite.UiTab}s).
   */
  default String getDefaultValidationFailure() {

    return "Please enter valid data.";
  }

  /**
   * @return a new instance of {@link UiValidState}.
   */
  default UiValidState newValidState() {

    return new UiValidState();
  }

}