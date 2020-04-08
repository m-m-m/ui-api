/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.dialog;

import io.github.mmm.base.exception.ObjectNotFoundException;

/**
 * Interface to manage {@link Dialog}s.
 *
 * @since 1.0.0
 */
public interface DialogManager {

  /**
   * @param dialogId the {@link Dialog#getId() ID} of the requested {@link Dialog}.
   * @return the requested {@link Dialog}.
   * @throws ObjectNotFoundException if no {@link Dialog} exists with the given {@code dialogId}.
   */
  Dialog getDialog(String dialogId);

  /**
   * @param type is the {@link Dialog#getType() type} of the requested {@link Dialog}.
   * @return the current {@link Dialog} with the given {@code type} or {@code null} if no {@link Dialog} is currently
   *         active for the given {@code type}.
   */
  Dialog getCurrentDialog(String type);

  /**
   * @return the current {@link Dialog#TYPE_MAIN main} {@link Dialog}.
   */
  default Dialog getCurrentMainDialog() {

    return getCurrentDialog(Dialog.TYPE_MAIN);
  }

  /**
   * @return the current {@link DialogPlace}. Will be <code>null</code> until initialized by first
   *         {@link #navigateTo(DialogPlace) navigation}.
   */
  DialogPlace getCurrentPlace();

  /**
   * This method navigates back in the history to the {@link DialogPlace} that has been visited before. In a
   * web-application this can also be triggered by pressing the back button.
   */
  void navigateBack();

  /**
   * This method navigates forward in the history. After {@link #navigateBack()} was invoked, this method will go to the
   * {@link DialogPlace} that has been visited before the invocation of {@link #navigateBack()}. In a web-application
   * this can also be triggered by pressing the forward button.
   */
  void navigateForward();

  /**
   * @param place is the {@link DialogPlace} identifying the {@link Dialog} to open.
   */
  void navigateTo(DialogPlace place);

}
