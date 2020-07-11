/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api;

import java.util.Locale;

import io.github.mmm.ui.impl.UiLocalizerProvider;

/**
 * An abstraction of {@link java.util.ResourceBundle}
 */
public interface UiLocalizer {

  /** The default {@link #localize(String) localization key} for a validation failure. */
  String KEY_DEFAULT_VALIDATION_FAILURE = "_invalid";

  /**
   * The {@link #localize(String) key} or key-suffix for the {@link io.github.mmm.ui.api.widget.UiWidget#getTooltip()
   * tooltip}.
   */
  String KEY_TOOLTIP = "_tooltip";

  /**
   * The {@link #localize(String) key} or key-suffix for the
   * {@link io.github.mmm.ui.api.event.action.UiAction#requireConfirmation() confirmation}.
   */
  String KEY_CONFIRM = "_confirm";

  /**
   * The {@link #localize(String) key} or key-suffix for the {@link io.github.mmm.ui.api.widget.img.UiIcon#getIconId()
   * icon ID}.
   */
  String KEY_ICON = "_icon";

  /**
   * @return the {@link Locale} of the current user.
   */
  Locale getLocale();

  /**
   * Please read JavaDoc of {@link #localizeOrNull(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Will be {@code key} if no
   *         localization is available.
   * @see #localizeOrNull(String, Object)
   */
  default String localize(String key) {

    String result = localizeOrNull(key);
    if (result == null) {
      result = key;
    }
    return result;
  }

  /**
   * Please read JavaDoc of {@link #localizeOrNull(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @param context the optional context of the key to localize. If not {@code null} it can identify a more specific
   *        {@link java.util.ResourceBundle}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Will be {@code key} if no
   *         localization is available.
   */
  default String localize(String key, Object context) {

    String result = localizeOrNull(key, context);
    if (result == null) {
      result = key;
    }
    return result;
  }

  /**
   * Please read JavaDoc of {@link #localizeOrNull(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Will be {@code null} if no
   *         localization is available.
   * @see #localizeOrNull(String, Object)
   */
  default String localizeOrNull(String key) {

    return localizeOrNull(key, null);
  }

  /**
   * Please read JavaDoc of {@link #localizeOrNull(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @param context the optional context of the key to localize. If not {@code null} it can identify a more specific
   *        {@link java.util.ResourceBundle}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Will be {@code null} if no
   *         localization is available.
   */
  default String localizeOrNull(String key, Object context) {

    return localizeOrNull(key, context, false);
  }

  /**
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @param context the optional context of the key to localize. If not {@code null} it can identify a more specific
   *        {@link java.util.ResourceBundle}. This allows to define a default localization for a general key but gives
   *        the localizer the ability to override this default with a specialized localization in that context. As an
   *        example we assume that {@code key} is "head". Now if the context is "HTML" or "Human" the ambiguous meaning
   *        of the key can be resolved and more appropriate localizations can be chosen. A common case is to localize
   *        properties of beans. Here the bean is provided as context so you have the freedom to choose a specific
   *        localization for a general property key such as "name" depending on the bean that defines the property
   *        without changing the actual UI code. Finally, the context may be a variant such as {@link #KEY_TOOLTIP} to
   *        derive a localized message for a different purpose.
   * @param contextOnly - {@code true} to return {@code null} in case no context specific localization is available and
   *        omit further fallback, {@code false} otherwise. When {@code true} is provided here, the {@code context}
   *        should not be {@code null} or this method will simply return {@code null}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Will be {@code null} if no
   *         localization is available.
   */
  String localizeOrNull(String key, Object context, boolean contextOnly);

  /**
   * @return the instance of this {@link UiLocalizer}.
   */
  static UiLocalizer get() {

    return UiLocalizerProvider.LOCALIZER;
  }

}
