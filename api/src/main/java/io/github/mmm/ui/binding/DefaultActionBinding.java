/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.binding;

import java.util.Objects;
import java.util.function.Consumer;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.event.UiClickEventListener;
import io.github.mmm.ui.event.action.UiAction;
import io.github.mmm.ui.widget.button.UiAbstractButton;

/**
 * Default implementation of {@link UiActionBinding}.
 *
 * @since 1.0.0
 */
public class DefaultActionBinding implements UiActionBinding {

  private static final DefaultActionBinding INSTANCE = new DefaultActionBinding();

  @Override
  public void bind(UiAction action, UiAbstractButton button) {

    UiContext context = button.getContext();
    String id = action.getId();
    Objects.requireNonNull(id, "id");
    button.setId(id);
    String label = action.getLabel();
    if (label == null) {
      label = context.localize(id);
      if (label == null) {
        label = CaseHelper.capitalize(id);
      }
    }
    button.setText(label);
    String tooltip = action.getTooltip();
    if (tooltip == null) {
      tooltip = context.localize(id + "_tooltip");
    }
    if (tooltip != null) {
      button.setTooltip(tooltip);
    }
    UiClickEventListener listener = e -> action.onEvent(e);
    if (action.requireConfirmation()) {
      String message = action.getConfirmationMessage();
      if (message == null) {
        message = context.localize(id + "_confirm");
      }
      if (message == null) {
        message = context.localize("confirm");
      }
      final String finalMessage = message;
      listener = (e) -> {
        Consumer<Boolean> callback = (choice) -> {
          if (Boolean.TRUE.equals(choice)) {
            action.onEvent(e);
          }
        };
        context.getNotifier().showPopupYesNo(finalMessage, null, callback);
      };
    }
    button.addListener(listener);
  }

  /**
   * @return the singleton instance.
   */
  public static UiActionBinding get() {

    return INSTANCE;
  }

}
