/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the API for dialog controllers and routing.
 * 
 * @uses io.github.mmm.ui.api.controller.UiNavigationManager
 */
module io.github.mmm.ui.api.controller {

  requires transitive io.github.mmm.ui.api.window;

  uses io.github.mmm.ui.api.controller.UiNavigationManager;

  exports io.github.mmm.ui.api.controller;

  exports io.github.mmm.ui.api.controller.action;

}
