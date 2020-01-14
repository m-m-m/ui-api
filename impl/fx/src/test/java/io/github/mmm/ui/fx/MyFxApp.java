/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.UiContext;
import javafx.application.Application;

/**
 *
 */
public class MyFxApp extends FxApplication {

  @Override
  protected void start(UiContext context) {

    new MyApp(context).run();
  }

  public static void main(String[] args) {

    Application.launch(MyFxApp.class, args);
  }

}
