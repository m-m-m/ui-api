/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEventListener;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.input.UiPasswordInput;
import io.github.mmm.ui.widget.input.UiTextArea;
import io.github.mmm.ui.widget.input.UiTextInput;
import io.github.mmm.ui.widget.menu.UiMenu;
import io.github.mmm.ui.widget.panel.UiFormPanel;
import io.github.mmm.ui.widget.panel.UiTabPanel;
import io.github.mmm.ui.widget.panel.UiVerticalPanel;
import io.github.mmm.ui.widget.window.UiMainWindow;

/**
 *
 */
public class MyApp {

  private final UiContext context;

  /**
   * The constructor.
   */
  public MyApp(UiContext context) {

    super();
    this.context = context;
  }

  public void run() {

    UiMainWindow mainWindow = this.context.getMainWindow();
    UiMenu fileMenu = mainWindow.getMenuBar().addMenu("File");
    fileMenu.addMenuItem("Exit", (e) -> {
      mainWindow.setVisible(false);
    });
    UiTabPanel tabPanel = this.context.createTabPanel();
    UiVerticalPanel page1 = this.context.createVerticalPanel();
    UiTab tab1 = tabPanel.addChild(page1, "Tab1");
    page1.addChild(this.context.createLabel("Hello World"));
    page1.addChild(this.context.createButton("OK", (e) -> {
      System.out.println("OK");
    }));
    UiVerticalPanel page2 = this.context.createVerticalPanel();
    UiTab tab2 = tabPanel.addChild(page2, "Tab2");
    UiVerticalPanel page3 = this.context.createVerticalPanel();
    page3.addChild(this.context.createLabel("Hi from Tab3"));
    UiTab tab3 = tabPanel.addChild(page3, "Tab3");

    UiCheckbox showTab1 = this.context.createCheckbox("Show Tab1");
    showTab1.setSelected(true);
    UiClickEventListener showTab1Listener = (e) -> {
      tab1.setVisible(showTab1.isSelected());
    };
    showTab1.addListener(showTab1Listener);
    UiCheckbox showTab3 = this.context.createCheckbox("Show Tab3");
    showTab3.setSelected(true);
    UiClickEventListener showTab3Listener = (e) -> {
      tab3.setVisible(showTab3.isSelected());
    };
    showTab3.addListener(showTab3Listener);
    UiTextInput textInput = this.context.createTextInput("Login");
    UiPasswordInput passwordInput = this.context.createPasswordInput("Password");
    UiTextArea textArea = this.context.createTextArea("Comment");
    UiFormPanel formPanel = this.context.createFormPanel(showTab1, showTab3, textInput, passwordInput, textArea);
    page2.addChild(formPanel);
    mainWindow.addChild(tabPanel);
    mainWindow.setVisible(true);
  }

}
