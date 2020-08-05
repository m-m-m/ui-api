/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.breadcrumb;

import io.github.mmm.ui.api.controller.UiNavigationManager;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;

/**
 * A {@link UiBreadCrumbBar} shows a <em>bread crumb</em> as a (horizontal) bar. The bread crumb displays the hierarchy
 * leading to the current dialogue and allows the user to click on the parent entries (hyperlinks) to navigate up this
 * hierarchy. Typically the last {@link UiBreadCrumbEntry entry} should be added via {@link #add(String)} without any
 * {@link UiClickEventListener}.
 *
 * @since 1.0.0
 */
public interface UiBreadCrumbBar extends UiRegularWidget, UiNativeWidget {

  /**
   * @param text the {@link UiBreadCrumbEntry#getText() label text} of the new entry.
   * @return the new {@link UiBreadCrumbEntry}.
   */
  UiBreadCrumbEntry add(String text);

  /**
   * @param text the {@link UiBreadCrumbEntry#getText() label text} of the new entry.
   * @param place the {@link UiPlace} where to {@link UiNavigationManager#navigateTo(UiPlace) navigate to} when the new
   *        bread crumb entry is clicked.
   * @param id the {@link UiBreadCrumbEntry#getId() ID} of the new entry.
   * @return the new {@link UiBreadCrumbEntry}.
   */
  default UiBreadCrumbEntry add(String text, UiPlace place, String id) {

    UiBreadCrumbEntry entry = add(text);
    UiClickEventListener listener = e -> {
      UiNavigationManager.get().navigateTo(place);
    };
    entry.addListener(listener);
    if (id != null) {
      entry.setId(id);
    }
    return entry;
  }

  /**
   * @param index the index of the requested entry. Should be in the range from {@code 0} to
   *        </code>{@link #getSize()}-1</code>.
   * @return the {@link UiBreadCrumbEntry} at the given index or {@code null} if no such entry exists.
   */
  UiBreadCrumbEntry get(int index);

  /**
   * Removes the {@link #getSize() last} {@link UiBreadCrumbEntry} from this {@link UiBreadCrumbBar}. So in other words
   * this method will undo the last {@link #add(String) add} operation.
   */
  void pop();

  /**
   * @return the current number of {@link UiBreadCrumbEntry entries} in this bread crumb bar.
   */
  int getSize();

  /**
   * Clears the bread crumb bar by removing all {@link UiBreadCrumbEntry entries}.
   */
  void clear();

}
