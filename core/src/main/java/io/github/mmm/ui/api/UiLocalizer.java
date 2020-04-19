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
   * The {@link #localize(String, Object, boolean) context} for the
   * {@link io.github.mmm.ui.api.widget.UiAtomicWidget#getTooltip() tooltip}.
   */
  String CONTEXT_TOOLTIP = "_tooltip";

  /**
   * The {@link #localize(String, Object, boolean) context} for the
   * {@link io.github.mmm.ui.api.event.action.UiAction#requireConfirmation() confirmation}.
   */
  String CONTEXT_CONFIRM = "_confirm";

  /**
   * @return the {@link Locale} of the current user.
   */
  Locale getLocale();

  /**
   * Please read JavaDoc of {@link #localize(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}.
   * @see #localize(String, Object)
   */
  default String localize(String key) {

    return localize(key, null);
  }

  /**
   * Please read JavaDoc of {@link #localize(String, Object, boolean)} before using.
   *
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @param context the optional context of the key to localize.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}.
   */
  default String localize(String key, Object context) {

    return localize(key, context, false);
  }

  /**
   * @param key the {@link java.util.ResourceBundle#getString(String) key}.
   * @param context the optional context of the key to localize. Allows to define a default localization for a general
   *        key but gives the localizer the ability to override this default with a specialized localization in that
   *        context. As an example we assume that {@code key} is "head". Now if the context is "HTML" or "Human" the
   *        ambiguous meaning of the key can be resolved and more appropriate localizations can be chosen. A common case
   *        is to localize properties of beans. Here the bean is provided as context so you have the freedom to choose a
   *        specific localization for a general property key such as "name" depending on the bean that defines the
   *        property without changing the actual UI code. Finally, the context may be a variant such as
   *        {@link #CONTEXT_TOOLTIP} to derive a localized message for a different purpose.
   * @param contextOnly - {@code true} to return {@code null} in case no context specific localization is available and
   *        omit further fallback, {@code false} otherwise. When {@code true} is provided here, the {@code context}
   *        should not be {@code null} or this method will simply return {@code null}.
   * @return the {@link java.util.ResourceBundle#getString(String) localized text}. Implementations may map the
   *         {@code context} to a different {@link java.util.ResourceBundle} or build a composed key as
   *         {@code «key»«context»}. If the localization for the specific context fails a general lookup without
   *         {@code context} has to be used as fallback. If no localization could be found at all the original
   *         {@code key} shall be returned. Users of this method shall design their keys such that this fallback still
   *         makes sense.
   */
  String localize(String key, Object context, boolean contextOnly);

  /**
   * @return the instance of this {@link UiLocalizer}.
   */
  static UiLocalizer get() {

    return UiLocalizerProvider.LOCALIZER;
  }

}
