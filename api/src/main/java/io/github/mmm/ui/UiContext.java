/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui;

import io.github.mmm.ui.event.UiClickEventListener;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.UiNativeWidget;
import io.github.mmm.ui.widget.UiWidget;
import io.github.mmm.ui.widget.button.UiButton;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.panel.UiHorizontalPanel;
import io.github.mmm.ui.widget.panel.UiTabPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.widget.window.UiMainWindow;

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
   * @param <W> type of the {@link UiNativeWidget} to create.
   * @param widgetInterface is the interface reflecting the {@link UiNativeWidget} to create. Shall not be
   *        {@link UiNativeWidget}.class itself.
   * @return the new {@link UiNativeWidget}.
   */
  <W extends UiNativeWidget> W create(Class<W> widgetInterface);

  /**
   * Creates a new {@link UiButton}.
   *
   * @see #createButton(UiHandlerAction)
   *
   * @param label the {@link UiButton#getLabel() label}.
   * @param listener the {@link UiEventListener}.
   * @return the new widget instance.
   */
  default UiButton createButton(String label, UiClickEventListener listener) {

    UiButton widget = create(UiButton.class);
    widget.setLabel(label);
    if (listener != null) {
      widget.addListener(listener);
    }
    return widget;
  }

  /**
   * @param label the {@link UiCheckbox#getLabel() label}.
   * @return the new widget instance.
   */
  default UiCheckbox createCheckbox(String label) {

    UiCheckbox widget = create(UiCheckbox.class);
    widget.setLabel(label);
    widget.setFieldLabel(label);
    return widget;
  }

  /**
   * Creates a new {@link UiLabel}.
   *
   * @param label is the {@link UiLabel#getLabel() label}.
   * @return the new widget instance.
   */
  default UiLabel createLabel(String label) {

    UiLabel widget = create(UiLabel.class);
    widget.setLabel(label);
    return widget;
  }

  /**
   * @return the new widget instance.
   */
  default UiTabPanel createTabPanel() {

    UiTabPanel tabPanel = create(UiTabPanel.class);
    return tabPanel;
  }

  /**
   * @return the new widget instance.
   */
  default UiVerticalPanel createVerticalPanel() {

    UiVerticalPanel verticalPanel = create(UiVerticalPanel.class);
    return verticalPanel;
  }

  /**
   * @return the new widget instance.
   */
  default UiHorizontalPanel createHorizontalPanel() {

    UiHorizontalPanel horizontalPanel = create(UiHorizontalPanel.class);
    return horizontalPanel;
  }

  /**
   * @return the {@link UiMainWindow} running this application. It will hold the {@link UiMainWindow#getMenuBar() menu
   *         bar} and should be the main entry point to your application for end-users.
   */
  UiMainWindow getMainWindow();

  // /**
  // * This method gets the {@link UiDisplay} e.g. to read the current screen resolution.
  // *
  // * @return the {@link UiDisplay}.
  // */
  // UiDisplay getDisplay();
  //
  // /**
  // * @return the {@link UiDispatcher}.
  // */
  // UiDispatcher getDispatcher();

  // /**
  // * This method gets the {@link UiWidgetFactory} that is used to create {@link io.github.mmm.ui.widget.UiWidget}s.
  // *
  // * @return the {@link UiWidgetFactory}.
  // */
  // UiWidgetFactory getWidgetFactory();

  // /**
  // * @return the instance of {@link UiPopupHelper}.
  // */
  // UiPopupHelper getPopupHelper();

  // /**
  // * This method gets the {@link UiConfiguration} for this factory. It is intended to be read by
  // * {@link net.sf.mmm.client.ui.api.widget.UiWidget} implementations to configure their look and feel.
  // *
  // * @return the {@link UiConfiguration}.
  // */
  // UiConfiguration getConfiguration();

  // /**
  // * @return the instance of {@link RoleFactory}.
  // */
  // RoleFactory getRoleFactory();

}