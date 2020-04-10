/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the API for dialog controllers and routing.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.api.controller {

  requires transitive io.github.mmm.ui.api.window;

  uses io.github.mmm.ui.api.controller.UiControllerManager;

  uses io.github.mmm.ui.api.controller.AbstractUiController;

  provides io.github.mmm.ui.api.controller.AbstractUiController with //
      io.github.mmm.ui.impl.controller.UiControllerRoot;

  exports io.github.mmm.ui.api.controller;

}
