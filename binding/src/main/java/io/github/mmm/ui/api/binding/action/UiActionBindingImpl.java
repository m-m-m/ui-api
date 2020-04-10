/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.action;

import java.util.Objects;
import java.util.function.Consumer;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;

/**
 * Default implementation of {@link UiActionBinding}.
 *
 * @since 1.0.0
 */
public class UiActionBindingImpl implements UiActionBinding {

  private static final UiActionBindingImpl INSTANCE = new UiActionBindingImpl();

  @Override
  public void bind(UiAction action, UiAbstractButton button) {

    UiContext context = UiContext.get();
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
        UiNotifier.get().showPopupYesNo(finalMessage, null, callback);
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
