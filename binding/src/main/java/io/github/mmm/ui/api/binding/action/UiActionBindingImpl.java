/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.binding.action;

import java.util.Objects;
import java.util.function.Consumer;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.binding.UiActionBinding;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.notifier.UiNotifier;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.api.widget.img.UiIcon;

/**
 * Default implementation of {@link UiActionBinding}.
 *
 * @since 1.0.0
 */
public class UiActionBindingImpl implements UiActionBinding {

  private static final UiActionBindingImpl INSTANCE = new UiActionBindingImpl();

  @Override
  public void bind(UiAction action, UiAbstractButton button) {

    UiLocalizer localizer = UiLocalizer.get();
    String id = action.getId();
    Objects.requireNonNull(id, "id");
    button.setId(id);
    bindLabelText(action, button, localizer, id);
    bindTooltip(action, button, localizer, id);
    bindIcon(action, button);
    bindListener(action, button);
  }

  private void bindListener(UiAction action, UiAbstractButton button) {

    UiClickEventListener listener = e -> action.onEvent(e);
    if (action.requireConfirmation()) {
      String message = action.getConfirmationMessage();
      if (message == null) {
        message = UiLocalizer.get().localize(action.getId() + UiLocalizer.KEY_CONFIRM);
      }
      if (message == null) {
        message = UiLocalizer.get().localize(UiLocalizer.KEY_CONFIRM);
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

  private void bindLabelText(UiAction action, UiAbstractButton button, UiLocalizer localizer, String id) {

    String label = action.getLabel();
    if (label == null) {
      label = localizer.localize(id);
      if (label == null) {
        label = CaseHelper.capitalize(id);
      }
    }
    button.setText(label);
  }

  private void bindTooltip(UiAction action, UiAbstractButton button, UiLocalizer localizer, String id) {

    String tooltip = action.getTooltip();
    if (tooltip == null) {
      tooltip = localizer.localize(id + UiLocalizer.KEY_TOOLTIP);
    }
    if (tooltip != null) {
      button.setTooltip(tooltip);
    }
  }

  private void bindIcon(UiAction action, UiAbstractButton button) {

    String iconId = action.getIconId();
    if (iconId == null) {
      iconId = UiLocalizer.get().localize(action.getId() + UiLocalizer.KEY_ICON);
    }
    if ((iconId != null) && !iconId.isEmpty()) {
      button.setImage(UiIcon.of(iconId));
    }
  }

  /**
   * @return the singleton instance.
   */
  public static UiActionBinding get() {

    return INSTANCE;
  }

}
