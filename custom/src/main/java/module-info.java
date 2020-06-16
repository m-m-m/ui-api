/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the API for custom widgets.
 */
module io.github.mmm.ui.api.custom {

  requires transitive io.github.mmm.ui.api.form;

  exports io.github.mmm.ui.api.widget.custom;

  exports io.github.mmm.ui.api.widget.custom.composite;

  exports io.github.mmm.ui.api.widget.custom.form;

  exports io.github.mmm.ui.api.widget.custom.panel;

}
