/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.event.action;

/**
 * {@link UiAction} for <em>search</em>. It will perform a search based on the users criteria data and show the
 * resulting hits.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionSearch extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Search";

  @Override
  default String getId() {

    return ACTION_ID;
  }

}
