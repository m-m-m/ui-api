/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller.action;

import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.controller.UiNavigationManager;
import io.github.mmm.ui.api.controller.UiPlace;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.action.UiAction;

/**
 * {@link UiAction} for <em>close</em>.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface UiActionNavigate extends UiAction {

  /** @see #getId() */
  String ACTION_ID = "Navigate";

  @Override
  default String getId() {

    return ACTION_ID;
  }

  /**
   * @param place the {@link UiPlace} to {@link UiNavigationManager#navigateTo(UiPlace) navigate to}.
   * @return the new {@link UiActionNavigate}.
   */
  static UiActionNavigate of(UiPlace place) {

    return new UiActionNavigate() {

      @Override
      public String getLabel() {

        String id = place.getId();
        String label = UiLocalizer.get().localize(id);
        if (label == null) {
          label = id;
        }
        return label;
      }

      @Override
      public void onEvent(UiEvent event) {

        UiNavigationManager.get().navigateTo(place);
      }
    };
  }

  /**
   * @param controllerId the {@link UiPlace#getId() controller ID} to {@link UiNavigationManager#navigateTo(UiPlace)
   *        navigate to}.
   * @return the new {@link UiActionNavigate}.
   */
  static UiActionNavigate ofId(String controllerId) {

    return of(new UiPlace(controllerId));
  }

}
