/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.impl.controller.UiControllerManagerProvider;

/**
 * Interface to manage {@link UiController}s.
 *
 * @since 1.0.0
 */
public interface UiControllerManager {

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
   * @param place is the {@link UiPlace} identifying the {@link UiController} to open.
   */
  void navigateTo(UiPlace place);

  /**
   * @return the instance of this {@link UiControllerManager}.
   */
  static UiControllerManager get() {

    return UiControllerManagerProvider.INSTANCE.getControllerManager();
  }

}
