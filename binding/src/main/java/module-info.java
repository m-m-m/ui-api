/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the API for binding of UI with properties and beans.
 */
module io.github.mmm.ui.api.binding {

  requires transitive io.github.mmm.ui.api.form;

  requires transitive io.github.mmm.ui.api.window;

  requires transitive io.github.mmm.entity.bean;

  provides io.github.mmm.ui.api.binding.UiActionBinding with //
      io.github.mmm.ui.api.binding.action.UiActionBindingImpl;

  exports io.github.mmm.ui.api.binding.data;

}
