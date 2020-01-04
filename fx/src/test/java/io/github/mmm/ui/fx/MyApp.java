/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEventListener;
import io.github.mmm.ui.widget.composite.UiTab;
import io.github.mmm.ui.widget.input.UiCheckbox;
import io.github.mmm.ui.widget.menu.UiMenu;
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
    UiCheckbox showTab1 = this.context.createCheckbox("Show Tab1");
    showTab1.setSelected(true);
    UiClickEventListener showTab1Listener = (e) -> {
      tab1.setVisible(showTab1.isSelected());
    };
    showTab1.addListener(showTab1Listener);
    page2.addChild(showTab1);
    mainWindow.addChild(tabPanel);
    mainWindow.setVisible(true);
  }

}
