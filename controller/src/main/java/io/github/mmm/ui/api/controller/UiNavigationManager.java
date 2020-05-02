/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.event.EventSource;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.impl.controller.UiNavigationManagerProvider;

/**
 * Interface to manage {@link UiController}s.
 *
 * @since 1.0.0
 */
public interface UiNavigationManager extends EventSource<UiNavigationEvent, UiNavigationEventListener> {

  /**
   * @param <W> type of the {@link UiController#getView() view}.
   * @param id the {@link UiController#getId() ID} of the requested {@link UiController}.
   * @return the requested {@link UiController} or {@code null} if no such {@link UiController} exists.
   */
  <W extends UiWidget> UiController<W> getController(String id);

  /**
   * @param <W> type of the {@link UiController#getView() view}.
   * @param id the {@link UiController#getId() ID} of the requested {@link UiController}.
   * @return the requested {@link UiController}.
   * @throws ObjectNotFoundException if no {@link UiController} exists with the given {@code id}.
   */
  default <W extends UiWidget> UiController<W> getRequiredController(String id) {

    UiController<W> controller = getController(id);
    if (controller == null) {
      throw new ObjectNotFoundException("UiController", id);
    }
    return controller;
  }

  /**
   * @param <W> type of the {@link UiController#getView() view}.
   * @param type is the {@link UiController#getType() type} of the requested {@link UiController}.
   * @return the current {@link UiController} with the given {@code type} or {@code null} if no {@link UiController} is
   *         currently active for the given {@code type}.
   */
  <W extends UiWidget> UiController<W> getCurrentDialog(String type);

  /**
   * @return the current {@link UiController#TYPE_MAIN main} {@link UiController}.
   */
  default UiController<?> getCurrentMainDialog() {

    return getCurrentDialog(UiController.TYPE_MAIN);
  }

  /**
   * @return the current {@link UiPlace}. Will be <code>null</code> until initialized by first
   *         {@link #navigateTo(UiPlace) navigation}.
   */
  UiPlace getCurrentPlace();

  /**
   * This method navigates back in the history to the {@link UiPlace} that has been visited before. In a web-application
   * this can also be triggered by pressing the back button.
   *
   * @return the new {@link UiPlace} that we just navigated back to. Will be {@code null} if there is no history left.
   */
  UiPlace navigateBack();

  /**
   * This method navigates forward in the history. After {@link #navigateBack()} was invoked, this method will go to the
   * {@link UiPlace} that has been visited before the invocation of {@link #navigateBack()}. In a web-application this
   * can also be triggered by pressing the forward button.
   *
   * @return the new {@link UiPlace} that we just navigated forward to. Will be {@code null} if we are already at the
   *         end of the history and nothing is left to navigate forward.
   */
  UiPlace navigateForward();

  /**
   * Navigates to the given {@link UiPlace}.
   *
   * @param place is the {@link UiPlace} identifying the {@link UiController} to open.
   */
  default void navigateTo(UiPlace place) {

    navigateTo(place, false);
  }

  /**
   * Navigates to the given {@link UiPlace}.
   *
   * @param place is the {@link UiPlace} identifying the {@link UiController} to open.
   * @param replace - if {@code true} the {@link #getCurrentPlace() current place} will be replaced with the given
   *        {@link UiPlace}, {@code false} otherwise (default). Replacing is e.g. helpful for {@link UiController}s that
   *        do logical decisions and only redirect to the actual {@link UiPlace}.
   */
  void navigateTo(UiPlace place, boolean replace);

  /**
   * Replaces the {@link #getCurrentPlace() current place} with the given {@link UiPlace} without creating a new entry
   * in the navigation history.
   *
   * @param place the updated {@link UiPlace}. Currently the {@link UiPlace#getId() ID} of the {@link #getCurrentPlace()
   *        current place} may not change. This is only to update {@link UiPlace#getParameters() parameters}. E.g. if
   *        you want to represent the selection of a master-detail dialog in the location (URL) you can use a
   *        {@link UiPlace#get(String) parameter}. This method allows to update the {@link UiPlace} and therefore the
   *        location without adding it to the history so {@link #navigateBack()} navigating back} is not replaying the
   *        entire history of the end-users selection what is typically undesired.
   */
  void updatePlace(UiPlace place);

  /**
   * @return the instance of this {@link UiNavigationManager}.
   */
  static UiNavigationManager get() {

    return UiNavigationManagerProvider.MANAGER;
  }

}
