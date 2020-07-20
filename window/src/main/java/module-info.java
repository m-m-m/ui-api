/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the API for binding of UI with properties and beans.
 * 
 * @uses io.github.mmm.ui.api.notifier.UiNotifier
 */
module io.github.mmm.ui.api.window {

  requires transitive io.github.mmm.ui.api.core;

  exports io.github.mmm.ui.api.notifier;

  exports io.github.mmm.ui.api.widget.window;

  exports io.github.mmm.ui.spi.window;

  uses io.github.mmm.ui.api.notifier.UiNotifier;

}
